package com.tofas.vehicleExpertize.repository;


import com.tofas.vehicleExpertize.model.entity.VehicleDamageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageTypeRepository extends JpaRepository<VehicleDamageType,Long> {
}
