package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.damage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class AutorolaDamageType {
    @JsonProperty("keyName")
    private String name;

    @JsonProperty("description")
    private String description;
}
