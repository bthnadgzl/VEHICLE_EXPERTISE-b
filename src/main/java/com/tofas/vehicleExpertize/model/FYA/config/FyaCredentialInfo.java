package com.tofas.vehicleExpertize.model.FYA.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "fya.user-credential")
public class FyaCredentialInfo {
    private String username;
    private String password;
}
