package com.tofas.vehicleExpertize.model.dto.request;

import lombok.Data;

@Data
public class ExpertiseReportRequest {
    private String dealer;
    private String category;
    private String brand;
    private String model;
    private String bodyType;
    private String startDate;
    private String endDate;
}
