package com.tofas.vehicleExpertize.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VehicleExpertiseRequest {
    @JsonProperty("entityId")
    private Integer vehicleId;
}
