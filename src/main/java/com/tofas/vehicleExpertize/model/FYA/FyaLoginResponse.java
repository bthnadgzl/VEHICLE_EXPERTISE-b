package com.tofas.vehicleExpertize.model.FYA;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FyaLoginResponse {
    private String idToken;
}
