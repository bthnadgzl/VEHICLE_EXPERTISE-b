package com.tofas.vehicleExpertize.model.dealerservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "dealer-service.api-url")
public class DealerServiceApiUrlInfo {
    private String fiatUrl;
    private String arjUrl;
}
