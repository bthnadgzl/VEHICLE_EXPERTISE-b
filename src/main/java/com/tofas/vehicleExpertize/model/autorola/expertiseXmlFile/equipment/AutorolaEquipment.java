package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.equipment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaEquipment implements Serializable {
    private static final long serialVersionUID = -2337778195512163026L;
    @JsonProperty("equipmentId")
    private String id;

    @JsonProperty("description")
    private String description;
}
