package com.tofas.vehicleExpertize.model.autorola.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaExpertiseResponse implements Serializable {
    private static final long serialVersionUID = -5134669351237586156L;

    @JsonProperty("vehicleInformation")
    private AutorolaVehicleInformation vehicleInfo;

    @JsonProperty("registrationInformation")
    private AutorolaRegistrationInformation registrationInfo;

    @JsonProperty("vehicleSpecification")
    private AutorolaVehicleSpecification autorolaVehicleSpecification;

}
