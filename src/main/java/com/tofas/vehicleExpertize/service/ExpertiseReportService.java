package com.tofas.vehicleExpertize.service;

import com.tofas.vehicleExpertize.model.dto.response.VehicleExpertiseFilterResponse;

import java.util.List;


public interface ExpertiseReportService {


    List<String> getModels();
    List<String> getBrands();
    List<String> getCategories();
    List<String> getBodyTypes();
    List<VehicleExpertiseFilterResponse> getVehicleExpertiseReports();


}
