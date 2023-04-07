package com.tofas.vehicleExpertize.model.dto.response;


import java.time.LocalDate;
public interface VehicleExpertiseFilterResponse {
     String getDealerName();
     String getBrand();
     String getModel();
     String getCategory();
     String getBodyType();
     LocalDate getExpertiseDate();
     String getExpertiseReportUrl();

}
