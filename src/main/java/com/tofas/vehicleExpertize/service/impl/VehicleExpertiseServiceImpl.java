package com.tofas.vehicleExpertize.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tofas.vehicleExpertize.exception.autorolaExceptions.AutorolaGetVehicleExpertiseDataException;
import com.tofas.vehicleExpertize.model.FYA.ValuationResult;
import com.tofas.vehicleExpertize.model.autorola.AutorolaMiscPriceResponse;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.AutorolaXMLFileResponse;
import com.tofas.vehicleExpertize.model.autorola.vehicle.AutorolaVehicleResponse;
import com.tofas.vehicleExpertize.model.dto.response.VehicleExpertiseResponse;
import com.tofas.vehicleExpertize.model.entity.Vehicle;
import com.tofas.vehicleExpertize.service.*;
import com.tofas.vehicleExpertize.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleExpertiseServiceImpl implements VehicleExpertiseService {
    private final static String AUTOROLA_TOKEN_KEY = "autorolaTokenKey";
    private final static String FYA_TOKEN_KEY = "fyaTokenKey";
    @Qualifier("objectMapper")
    private final ObjectMapper objectMapper;
    private final AutorolaClientService autorolaClientService;
    private final FyaClientService fyaClientService;
    private final CacheService cacheService;
    private final VehicleService vehicleService;

    private final Mapper mapper;

    @Override
    public VehicleExpertiseResponse createVehicleExpertiseData(Integer vehicleId) {

        boolean isInCache = checkCacheState(AUTOROLA_TOKEN_KEY);
        String token = !isInCache ? autorolaClientService.login() : cacheService.getTokenFromCache(AUTOROLA_TOKEN_KEY);

        AutorolaVehicleResponse autorolaVehicleResponse = autorolaClientService.getVehicleData(vehicleId, token);
        AutorolaXMLFileResponse xmlFileResponse = getAutorolaXMLFileData(vehicleId, token);
        Vehicle vehicle = mapper.mapToVehicleEntity(autorolaVehicleResponse, xmlFileResponse);
        var savedData = vehicleService.saveVehicle(vehicle);

        return mapper.mapVehicleExpertiseEntityToVehicleExpertiseResponse(vehicleId, savedData);
    }

    @Override
    public boolean sendValuationToFya(Integer vehicleId) {
        boolean isFyaTokenInCache = checkCacheState(FYA_TOKEN_KEY);
        String fyaToken = !isFyaTokenInCache ? fyaClientService.login() : cacheService.getTokenFromCache(FYA_TOKEN_KEY);

        boolean isAutorolaInCache = checkCacheState(AUTOROLA_TOKEN_KEY);
        String autorolaToken = !isAutorolaInCache ? autorolaClientService.login() : cacheService.getTokenFromCache(AUTOROLA_TOKEN_KEY);

        AutorolaMiscPriceResponse autorolaMiscPriceResponse = autorolaClientService.getMiscPrice(vehicleId, autorolaToken);
        Double price = autorolaMiscPriceResponse.getAutorolaMiscPrice().getPrice1();
        Long date = autorolaMiscPriceResponse.getAutorolaMiscDate().getDate1();
        ValuationResult mappedValuationResult = mapper.mapValuationResult(vehicleId, price, date);

      return   fyaClientService.sendValuationResultToFya(mappedValuationResult, fyaToken);

    }

    private AutorolaXMLFileResponse getAutorolaXMLFileData(Integer vehicleId, String token) {
        //region GET XMLFILE BY VEHICLEID(ENTITY ID) AND TOKEN
        try {
            String dataSheetUrl = autorolaClientService.getExpertiseXMLDataSheetUrl(vehicleId, token);
            String jsonString = autorolaClientService.getExpertiseFileDataAsJsonString(dataSheetUrl);
            //endregion
            //region CONVERT XMLFILE TO OBJECT BY OBJECT MAPPER
            AutorolaXMLFileResponse autorolaXMLFileResponse = objectMapper.readValue(jsonString, AutorolaXMLFileResponse.class);
            autorolaXMLFileResponse.setAutorolaXmlFileUrl(dataSheetUrl);
            //endregion
            return autorolaXMLFileResponse;
        } catch (Exception ex) {
            throw new AutorolaGetVehicleExpertiseDataException("ssss");
        }

    }

    private String getAuthTokenByAutorolaLogin() {
        boolean isTokenExpire = cacheService.isCachedTokenExpire(AUTOROLA_TOKEN_KEY);
        boolean isTokenExist = cacheService.isTokenCachedExist(AUTOROLA_TOKEN_KEY);
        if (isTokenExpire && !isTokenExist) {
            return autorolaClientService.login();
        } else {
            return cacheService.getTokenFromCache(AUTOROLA_TOKEN_KEY);
        }

    }

    private String getAuthTokenByFyaLogin() {
        boolean isTokenExpire = cacheService.isCachedTokenExpire(FYA_TOKEN_KEY);
        boolean isTokenExist = cacheService.isTokenCachedExist(FYA_TOKEN_KEY);
        if (isTokenExpire || !isTokenExist) {
            cacheService.isTokenCachedExist(FYA_TOKEN_KEY);
            return fyaClientService.login();
        } else {
            return cacheService.getTokenFromCache(FYA_TOKEN_KEY);
        }
    }

    private boolean checkCacheState(String cacheKey) {
        boolean isTokenExistInCache = cacheService.isTokenCachedExist(cacheKey);
        boolean isTokenExpire = cacheService.isCachedTokenExpire(cacheKey);
        return (!isTokenExistInCache || isTokenExpire) ? false : true;
    }
}
