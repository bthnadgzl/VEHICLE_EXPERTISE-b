package com.tofas.vehicleExpertize.service;

import com.tofas.vehicleExpertize.model.autorola.AutorolaMiscPriceResponse;
import com.tofas.vehicleExpertize.model.autorola.vehicle.AutorolaVehicleResponse;
import com.tofas.vehicleExpertize.model.dto.response.VehicleValuationResponse;

public interface AutorolaClientService {
    String login();

    AutorolaVehicleResponse getVehicleData(Integer vehicleId, String token);

    String getExpertiseXMLDataSheetUrl(Integer vehicleId, String token) ;

    String getExpertiseFileDataAsJsonString(String sourceUrl) ;

    VehicleValuationResponse getVehicleValuation(Integer vehicleId, String token) ;

    AutorolaMiscPriceResponse getMiscPrice(Integer vehicleId, String token);

}
