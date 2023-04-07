package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.damage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties
public class AutorolaDamageLocation implements Serializable {
    private static final long serialVersionUID = 7927732226552610946L;

    @JsonProperty("keyName")
    private String name;

    @JsonProperty("description")
    private String description;
}
