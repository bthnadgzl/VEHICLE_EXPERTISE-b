package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.equipment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaVehicleEquipment implements Serializable {
    private static final long serialVersionUID = 2166242062774007575L;
    @JsonProperty("equipmentStandard")
    private List<AutorolaEquipment> standardAutorolaEquipment;

}
