package com.tofas.vehicleExpertize.model.dealerservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DealerServiceResponse {
    private String brand;
    @JsonProperty(value = "code")
    private String dealerId;
    @JsonProperty(value = "name")
    private String dealerName;
    private String regioun;
    private String title;

}
