package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaVehicleReference implements Serializable {
    private static final long serialVersionUID = 3895245553956657800L;

    @JsonProperty("regNo")
    private String licencePlate;
    @JsonProperty("frameNo")
    private String vin;

}
