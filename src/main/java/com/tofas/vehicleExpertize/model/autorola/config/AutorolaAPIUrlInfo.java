package com.tofas.vehicleExpertize.model.autorola.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "autorola.api-url")
public class AutorolaAPIUrlInfo {
    private String baseUrl;
    private String loginUrl;
    private String fileUrl;
    private String vehicleUrl;


}
