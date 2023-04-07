package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.damage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaDamagePictures implements Serializable {
    private static final long serialVersionUID = 5793283469260427213L;

    @JsonProperty("damagePicture")
    List<AutorolaDamagePicture> picturelist;
}
