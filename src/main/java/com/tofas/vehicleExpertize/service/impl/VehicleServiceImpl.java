package com.tofas.vehicleExpertize.service.impl;

import com.tofas.vehicleExpertize.model.entity.Vehicle;
import com.tofas.vehicleExpertize.repository.VehicleRepository;
import com.tofas.vehicleExpertize.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

}
