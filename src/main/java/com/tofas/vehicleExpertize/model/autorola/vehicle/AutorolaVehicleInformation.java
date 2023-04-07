package com.tofas.vehicleExpertize.model.autorola.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tofas.vehicleExpertize.constant.VehicleCategory;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaVehicleInformation implements Serializable {
    private static final long serialVersionUID = -4501557097460202252L;

    @JsonProperty("carCategory")
    private VehicleCategory category;
}
