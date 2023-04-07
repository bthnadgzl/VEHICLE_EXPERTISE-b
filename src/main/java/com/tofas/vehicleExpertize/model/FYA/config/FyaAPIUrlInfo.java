package com.tofas.vehicleExpertize.model.FYA.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "fya.api-url")
public class FyaAPIUrlInfo {
    private String baseUrl;
    private String loginUrl;
    private String valuationUrl;




}
