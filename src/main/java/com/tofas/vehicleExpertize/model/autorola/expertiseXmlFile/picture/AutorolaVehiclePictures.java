package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.picture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaVehiclePictures implements Serializable {
    private static final long serialVersionUID = 5641281532376837496L;

    @JsonProperty("picture")
    private List<AutorolaVehiclePicture> autorolaVehiclePicture;
}
