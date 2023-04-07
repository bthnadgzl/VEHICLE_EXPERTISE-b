package com.tofas.vehicleExpertize.model.autorola.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "autorola.user-credential")
public class AutorolaCredentialInfo {
    private String username;
    private String password;
}
