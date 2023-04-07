package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaVehicleData implements Serializable {
    private static final long serialVersionUID = -8325861474990902061L;

    private String bodyType;
    private Integer faceliftPeriodTo;
    @JsonProperty("faceliftPeriodFrom")
    private Integer modelYear;
    private String modelName;
    private String carColourText;
    @JsonProperty("km")
    private AutorolaLastKm km;
    @JsonProperty("engineFuelType")
    private String fuelType;
    @JsonProperty("transmissionType")
    private String transmission;
    private String metallicPaint;
    private String variantName;
    private String makeName;
    private Integer keys;


}
