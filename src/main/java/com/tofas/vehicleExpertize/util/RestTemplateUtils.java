package com.tofas.vehicleExpertize.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Objects.isNull;

public class RestTemplateUtils {


    public static HttpEntity createHttpHeader(String tokenKey, String tokenValue) {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put(tokenKey, tokenValue);
        var headerParamMap = Optional.of(stringStringMap);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));

        if (headerParamMap.isPresent() && headerParamMap.get().size() > 0)
            headerParamMap.get().entrySet().stream().forEach(x -> {
                var isTokenExist = !isNull(x.getKey()) && x.getKey().equals(tokenKey);

                if (isTokenExist)
                    httpHeaders.setBearerAuth(x.getValue());

            });
        return new HttpEntity(httpHeaders);

    }

    public static boolean isTokenExpire(String token) {
        String[] tokenParts = token.split("//.");
        //   new String(Base64.getUrlDecoder().decode();
        return false;
    }
}
