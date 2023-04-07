package com.tofas.vehicleExpertize.model.autorola.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaContract implements Serializable {
    private static final long serialVersionUID = 6208699821362294585L;

    @JsonProperty("portfolio")
    private String dealerCode;
}
