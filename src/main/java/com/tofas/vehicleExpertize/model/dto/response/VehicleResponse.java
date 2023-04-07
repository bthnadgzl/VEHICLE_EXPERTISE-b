package com.tofas.vehicleExpertize.model.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class VehicleResponse {

    private String vin;//frameNo
    private String brand;//makeName
    private String model;//model
    private String variant;//varianat
    private String insertedBy = "SYSTEM";//insertBy Expertize App
    private LocalDate insertedDate = LocalDate.now();
    private LocalDateTime createdAt;//Autorola created date
    private String category;//car category -Binek, - Ticari, -TANIMSIZ
    private Integer modelYear;//faceliftPeriodFrom
    private String segment; //segment *
    private String bodyType;//bodyType
    private String fuelType;//engineFuelType
    private String engine;
    private String transmission;//transmissionType
    private Integer hp;
    private Integer kw;
    //private String wheels_drive;
    private String updated_by;
    private LocalDateTime updated_at;
}
