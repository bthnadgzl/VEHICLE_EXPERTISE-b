package com.tofas.vehicleExpertize.repository;


import com.tofas.vehicleExpertize.model.dto.response.VehicleExpertiseFilterResponse;
import com.tofas.vehicleExpertize.model.entity.VehicleExpertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleExpertiseRepository extends JpaRepository<VehicleExpertise,Long> {

    @Query(value = "SELECT d.dealer_name as dealerName, v.brand as brand, v.model as model, v.category as category, " +
            "v.body_type as bodyType, e.expertise_date as expertiseDate, e.expertise_report_url as expertiseReportUrl" +
            " FROM VEHICLE_EXPERTISE as e " +
            "INNER JOIN Dealer as d ON e.dealer_id = d.dealer_id " +
            "INNER JOIN Vehicle as v ON e.vin = v.vin", nativeQuery = true)
    List<VehicleExpertiseFilterResponse> getVehicleExpertiseReports();
}
