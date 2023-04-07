package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.damage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaDamagePicture implements Serializable {
    private static final long serialVersionUID = 6369308908073290321L;

    @JsonProperty("damage")
    private String damage;

    @JsonProperty("content")
    private String content;
}
