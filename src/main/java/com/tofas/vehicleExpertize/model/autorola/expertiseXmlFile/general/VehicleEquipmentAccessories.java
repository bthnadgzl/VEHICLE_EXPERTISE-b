package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleEquipmentAccessories implements Serializable {
    private static final long serialVersionUID = -6138386408494001357L;

    @JsonProperty("notes")
    private String notes ="";
}
