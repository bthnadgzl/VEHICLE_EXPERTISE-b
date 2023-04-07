package com.tofas.vehicleExpertize.service.impl;

import com.tofas.vehicleExpertize.constant.DocumentTypes;
import com.tofas.vehicleExpertize.exception.autorolaExceptions.AutorolaLoginException;
import com.tofas.vehicleExpertize.model.autorola.AutorolaLoginResponse;
import com.tofas.vehicleExpertize.model.autorola.AutorolaMiscPriceResponse;
import com.tofas.vehicleExpertize.model.autorola.config.AutorolaAPIUrlInfo;
import com.tofas.vehicleExpertize.model.autorola.config.AutorolaCredentialInfo;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.AutorolaGetFilesInfoResponse;
import com.tofas.vehicleExpertize.model.autorola.vehicle.AutorolaVehicleResponse;
import com.tofas.vehicleExpertize.model.dto.response.VehicleValuationResponse;
import com.tofas.vehicleExpertize.service.AutorolaClientService;
import com.tofas.vehicleExpertize.service.CacheService;
import lombok.AllArgsConstructor;
import org.json.XML;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.tofas.vehicleExpertize.util.RestTemplateUtils.createHttpHeader;

@Service
@AllArgsConstructor
public class AutorolaClientServiceImpl implements AutorolaClientService {

    private final static String HEADER_TOKEN_KEY = "autorolaTokenKey";

    private final RestTemplate restTemplate;

    private final CacheService cacheService;

    private final AutorolaCredentialInfo credentialInfoAutorolaCredential;
    private final AutorolaAPIUrlInfo autorolaAPIUrlInfo;

    @Override
    public String login() {
        ResponseEntity<AutorolaLoginResponse> responseEntity;
        String loginUrl = new StringBuilder(autorolaAPIUrlInfo.getBaseUrl())
                .append(autorolaAPIUrlInfo.getLoginUrl()).toString();
        try {
            responseEntity = restTemplate.postForEntity(loginUrl, credentialInfoAutorolaCredential, AutorolaLoginResponse.class);
        } catch (HttpClientErrorException ex) {
            throw new AutorolaLoginException(ex.getStatusCode());
        }

        String token = responseEntity.getBody().getToken();
        cacheService.addTokenToCache(token, HEADER_TOKEN_KEY);
        return token;
    }

    @Override
    public AutorolaVehicleResponse getVehicleData(Integer vehicleId, String token) {

        String getVehicleUrl = new StringBuilder(autorolaAPIUrlInfo.getBaseUrl())
                .append(autorolaAPIUrlInfo.getVehicleUrl())
                .append("/")
                .append(vehicleId).toString();

        HttpEntity httpEntity = createHttpHeader(HEADER_TOKEN_KEY, token);
        var responseEntity = restTemplate.exchange(getVehicleUrl, HttpMethod.GET, httpEntity, AutorolaVehicleResponse.class);
        return responseEntity.getBody();
    }

    @Override
    public String getExpertiseXMLDataSheetUrl(Integer vehicleId, String token) {

        HttpEntity httpEntity = createHttpHeader(HEADER_TOKEN_KEY, token);

        String expertiseUrl = new StringBuilder(autorolaAPIUrlInfo.getBaseUrl())
                .append(autorolaAPIUrlInfo.getFileUrl())
                .append("/")
                .append(vehicleId)
                .append("/").append(DocumentTypes.DESCRIPTION_XML_TYPE.name()).toString();

        var responseEntity = restTemplate.exchange(expertiseUrl, HttpMethod.GET, httpEntity, AutorolaGetFilesInfoResponse.class);
        return responseEntity.getBody().getAutorolaFiles().stream().findFirst().get().getUrl();
    }

    @Override
    public String getExpertiseFileDataAsJsonString(String sourceUrl) {
        var resultAsXML = restTemplate.getForObject(sourceUrl, String.class);
        return XML.toJSONObject(resultAsXML).toString();
    }

    @Override
    public VehicleValuationResponse getVehicleValuation(Integer vehicleId, String token) {
        return null;
    }

    @Override
    public AutorolaMiscPriceResponse getMiscPrice(Integer vehicleId, String token) {

        String autorolaVehicleInfoUrl = new StringBuilder(autorolaAPIUrlInfo.getBaseUrl())
                .append(autorolaAPIUrlInfo.getVehicleUrl())
                .append("/").toString();


        HttpEntity httpEntity = createHttpHeader(HEADER_TOKEN_KEY, token);
        var responseEntity = restTemplate.exchange(autorolaVehicleInfoUrl + vehicleId.toString(), HttpMethod.GET, httpEntity, AutorolaMiscPriceResponse.class);

        return responseEntity.getBody();
    }


}
