package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.AutorolaVehicleReference;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaVehicleGeneralData implements Serializable {
    private static final long serialVersionUID = -5864282255156637114L;

    @JsonProperty("carReference")
    private AutorolaVehicleReference autorolaVehicleReference;

    @JsonProperty("carData")
    private AutorolaVehicleData autorolaVehicleData;

   @JsonProperty("carEquipmentFeaturesAccessories")
    private VehicleEquipmentAccessories vehicleEquipmentAccessories;
}
