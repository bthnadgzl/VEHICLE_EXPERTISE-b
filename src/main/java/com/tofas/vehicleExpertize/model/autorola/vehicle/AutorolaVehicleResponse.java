package com.tofas.vehicleExpertize.model.autorola.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaVehicleResponse implements Serializable {
    private static final long serialVersionUID = -6206640858266390705L;

    @JsonProperty("carId")
    private Integer vehicleId;
    @JsonProperty("vehicleInformation")
    private AutorolaVehicleInformation autorolaVehicleInformation;
    @JsonProperty("registrationInformation")
    private AutorolaRegistrationInformation autorolaRegistrationInformation;
    @JsonProperty("vehicleSpecification")
    private AutorolaVehicleSpecification autorolaVehicleSpecification;
    @JsonProperty("tradeIn")
    private AutorolaVehicleTradeIn autorolaVehicleTradeIn;
    @JsonProperty("contract")
    private AutorolaContract autorolaContract;



}
