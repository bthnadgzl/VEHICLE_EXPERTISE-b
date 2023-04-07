package com.tofas.vehicleExpertize.repository;



import com.tofas.vehicleExpertize.model.entity.VehicleDamageLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageLocationRepository extends JpaRepository<VehicleDamageLocation, Long> {
}
