package com.tofas.vehicleExpertize.model.autorola.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaRegistrationInformation implements Serializable {
    private static final long serialVersionUID = 7795468311537193847L;

    @JsonProperty("regNo")
    private String licencePlate;
}
