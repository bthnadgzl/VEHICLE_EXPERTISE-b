package com.tofas.vehicleExpertize.repository;

import com.tofas.vehicleExpertize.model.entity.VehicleDamage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDamageRepository extends JpaRepository<VehicleDamage,Long> {
}
