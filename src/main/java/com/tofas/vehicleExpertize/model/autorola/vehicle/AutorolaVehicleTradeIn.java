package com.tofas.vehicleExpertize.model.autorola.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaVehicleTradeIn implements Serializable {
    private static final long serialVersionUID = 300580609499787949L;

    private Timestamp vehicleCreateDate;
    @JsonProperty("tradeInPrice")
    private Double tradeInPrice;

    private Boolean acceptPrice;
}
