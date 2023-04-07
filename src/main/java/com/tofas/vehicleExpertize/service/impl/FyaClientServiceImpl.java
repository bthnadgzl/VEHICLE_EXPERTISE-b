package com.tofas.vehicleExpertize.service.impl;

import com.tofas.vehicleExpertize.exception.autorolaExceptions.FyaValuationException;
import com.tofas.vehicleExpertize.model.FYA.FyaLoginResponse;
import com.tofas.vehicleExpertize.model.FYA.ValuationResult;
import com.tofas.vehicleExpertize.model.FYA.config.FyaAPIUrlInfo;
import com.tofas.vehicleExpertize.model.FYA.config.FyaCredentialInfo;
import com.tofas.vehicleExpertize.model.autorola.vehicle.AutorolaVehicleResponse;
import com.tofas.vehicleExpertize.service.CacheService;
import com.tofas.vehicleExpertize.service.FyaClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.tofas.vehicleExpertize.util.RestTemplateUtils.createHttpHeader;

@Service
@AllArgsConstructor
public class FyaClientServiceImpl implements FyaClientService {
    private final static String HEADER_TOKEN_KEY = "fyaTokenKey";
    private final FyaCredentialInfo fyaCredentialInfo;
    private final FyaAPIUrlInfo fyaAPIUrlInfo;
    private final RestTemplate restTemplate;
    private final CacheService cacheService;

    @Override
    public String login() {
        String loginUrl = new StringBuilder(fyaAPIUrlInfo.getBaseUrl())
                .append(fyaAPIUrlInfo.getLoginUrl()).toString();

        var responseEntity = restTemplate.postForEntity(loginUrl, fyaCredentialInfo, FyaLoginResponse.class);
        String token = responseEntity.getBody().getIdToken().substring("Bearer ".length());
        cacheService.addTokenToCache(token, HEADER_TOKEN_KEY);
        return token;
    }

    @Override
    public boolean sendValuationResultToFya(ValuationResult valuationResult, String token) {
        String valuationUrl = new StringBuilder(fyaAPIUrlInfo.getBaseUrl())
                .append(fyaAPIUrlInfo.getValuationUrl()).toString();

        HttpEntity httpEntity = createHttpHeader(HEADER_TOKEN_KEY, token);

        try {
            var responseEntity = restTemplate.postForEntity(valuationUrl, valuationResult, AutorolaVehicleResponse.class, httpEntity);
            return responseEntity.getStatusCode().is2xxSuccessful() ? true : false;
        } catch (HttpClientErrorException ex) {
            throw new FyaValuationException(ex.getStatusCode());
        }
    }
}
