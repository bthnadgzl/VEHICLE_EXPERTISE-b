package com.tofas.vehicleExpertize.service.impl;

import com.tofas.vehicleExpertize.model.dto.request.VehicleEquipmentRequest;
import com.tofas.vehicleExpertize.model.entity.VehicleEquipment;
import com.tofas.vehicleExpertize.repository.VehicleEquipmentRepository;
import com.tofas.vehicleExpertize.service.VehicleEquipmentService;
import com.tofas.vehicleExpertize.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class VehicleEquipmentServiceImpl implements VehicleEquipmentService {

    private final VehicleEquipmentRepository vehicleEquipmentRepository;
    private final Mapper mapper;

    @Override
    public void saveVehicleEquipment(VehicleEquipmentRequest vehicleEquipmentRequest) {
        var vehicleEquipmentEntity = mapper.mapSourceToTarget(vehicleEquipmentRequest, VehicleEquipment.class);
        vehicleEquipmentRepository.save(vehicleEquipmentEntity);
    }
}
