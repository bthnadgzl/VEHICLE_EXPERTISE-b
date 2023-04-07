package com.tofas.vehicleExpertize.repository;


import com.tofas.vehicleExpertize.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    @Query(value = "SELECT DISTINCT UPPER(model) FROM VEHICLE", nativeQuery = true)
    List<String> findModels();

    @Query(value = "SELECT DISTINCT UPPER(brand) FROM VEHICLE", nativeQuery = true)
    List<String> findBrands();

    @Query(value = "SELECT DISTINCT UPPER(category) FROM VEHICLE", nativeQuery = true)
    List<String> findCategories();
    @Query(value = "SELECT DISTINCT UPPER(body_type) FROM VEHICLE", nativeQuery = true)
    List<String> findBodyTypes();


}
