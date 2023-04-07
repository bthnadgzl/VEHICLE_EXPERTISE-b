package com.tofas.vehicleExpertize.repository;


import com.tofas.vehicleExpertize.model.entity.VehicleEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleEquipmentRepository extends JpaRepository<VehicleEquipment,Long> {
}
