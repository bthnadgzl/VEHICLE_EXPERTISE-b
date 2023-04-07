package com.tofas.vehicleExpertize.service;

import com.tofas.vehicleExpertize.model.dto.response.VehicleExpertiseResponse;

public interface VehicleExpertiseService {
     VehicleExpertiseResponse createVehicleExpertiseData(Integer vehicleId) throws Exception;
    boolean sendValuationToFya(Integer vehicleId) ;
}
