package com.tofas.vehicleExpertize.model.autorola.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaMiscPrice implements Serializable {
    private static final long serialVersionUID = 3053612464059371140L;
    @JsonProperty("price1")
    private double price1;
}
