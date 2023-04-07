package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.picture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaVehiclePicture implements Serializable {
    private static final long serialVersionUID = -5911402857122145068L;

    @JsonProperty("description")
    private String description;

    @JsonProperty("content")
    private String content;
}
