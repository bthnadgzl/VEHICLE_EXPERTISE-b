package com.tofas.vehicleExpertize.model.autorola.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaMiscDate implements Serializable {
    private static final long serialVersionUID = -551287248356292867L;
    @JsonProperty("date1")
    private long date1;
}
