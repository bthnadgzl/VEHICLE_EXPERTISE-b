package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.damage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaDamages implements Serializable {
    private static final long serialVersionUID = -5890710904197720102L;

    @JsonProperty("damagePictures")
    private AutorolaDamagePictures autorolaDamagePictures;

    @JsonProperty("damage")
    private List<AutorolaDamage> autorolaDamage;

}
