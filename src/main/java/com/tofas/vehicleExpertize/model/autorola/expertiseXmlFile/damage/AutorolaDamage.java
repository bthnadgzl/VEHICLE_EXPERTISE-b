package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.damage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaDamage implements Serializable {
    private static final long serialVersionUID = -5890710904197720102L;

    @JsonProperty("severity")
    private AutorolaDamageSeverity severity;

    @JsonProperty("location")
    private AutorolaDamageLocation location;

    @JsonProperty("type")
    private AutorolaDamageType Type;

}
