package com.tofas.vehicleExpertize.model.autorola.vehicle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaVehicleSpecification implements Serializable {
    private static final long serialVersionUID = 6059071619051822450L;

    @JsonProperty("frameNo")
    private String vin;

    @JsonProperty("km")
    private Integer km;

    @JsonProperty("modelName")
    private String model;

    @JsonProperty("variantName")
    private String variant;

    @JsonProperty("makeName")
    private String brand;

    @JsonProperty("engFuelType")
    private String fuelType;

    @JsonProperty("kw")
    private Integer kw;

    @JsonProperty("hp")
    private Integer hp;

    @JsonProperty("bdyType")
    private String bodyType;

    //private String carColourCode;
    //private String trmNbSpeeds;
    //private String material;
    //private String nbSeats;
    //private String carColourText;
    //private int latestServiceKm;
    //private int engDisplCcm;

    //private TransmissionType trmType;
    // private String engDisplL;
    //private String materialDescription;
    // private String cabinColourCode;
//  private int bdyNbDoors;

}
