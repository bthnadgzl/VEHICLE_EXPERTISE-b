package com.tofas.vehicleExpertize.service.impl;

import com.tofas.vehicleExpertize.model.entity.VehicleExpertise;
import com.tofas.vehicleExpertize.repository.VehicleExpertiseRepository;
import com.tofas.vehicleExpertize.service.ExpertiseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ExpertiseServiceImpl implements ExpertiseService {

    private final VehicleExpertiseRepository vehicleExpertiseRepository;

    @Override
    public VehicleExpertise saveVehicleExpertise(VehicleExpertise vehicleExpertise) {
      return  vehicleExpertiseRepository.save(vehicleExpertise);
    }
}
