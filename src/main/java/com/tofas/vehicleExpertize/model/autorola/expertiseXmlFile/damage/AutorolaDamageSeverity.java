package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.damage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaDamageSeverity implements Serializable {
    private static final long serialVersionUID = -5890710904197720102L;

    @JsonProperty("keyName")
    private String name;

    @JsonProperty("description")
    private String description;
}
