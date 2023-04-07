package com.tofas.vehicleExpertize.controller;

import com.tofas.vehicleExpertize.constant.DamageLocations;
import com.tofas.vehicleExpertize.constant.DamageTypes;
import com.tofas.vehicleExpertize.constant.VehicleEquipments;
import com.tofas.vehicleExpertize.model.entity.Dealer;
import com.tofas.vehicleExpertize.model.entity.VehicleDamageLocation;
import com.tofas.vehicleExpertize.model.entity.VehicleDamageType;
import com.tofas.vehicleExpertize.model.entity.VehicleEquipment;
import com.tofas.vehicleExpertize.repository.DamageLocationRepository;
import com.tofas.vehicleExpertize.repository.DamageTypeRepository;
import com.tofas.vehicleExpertize.repository.DealerRepository;
import com.tofas.vehicleExpertize.repository.VehicleEquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/init")
@AllArgsConstructor
public class InıtController {

    private final VehicleEquipmentRepository vehicleEquipmentRepository;
    private final DealerRepository dealerRepository;
    private final DamageLocationRepository damageLocationRepository;
    private final DamageTypeRepository damageTypeRepository;

    @GetMapping
    public void init() {
        for (VehicleEquipments eq : VehicleEquipments.values()
        ) {
            VehicleEquipment equipment = new VehicleEquipment();
          //  equipment.setState("Active");
            equipment.setKeyName(eq.name());
            equipment.setTypeName("Standard");
            equipment.setValueName(eq.getDescription());
            vehicleEquipmentRepository.save(equipment);
        }

        for (DamageLocations damageLocat : DamageLocations.values()
        ) {
            VehicleDamageLocation vehicleDamageLocation = new VehicleDamageLocation();
            vehicleDamageLocation.setId(damageLocat.getId());
            vehicleDamageLocation.setKeyName(damageLocat.getKeyName());
            vehicleDamageLocation.setDescription(damageLocat.getDescription());
            damageLocationRepository.save(vehicleDamageLocation);
        }
        for (DamageTypes damageTy : DamageTypes.values()
        ) {
            VehicleDamageType vehicleDamageType = new VehicleDamageType();
            vehicleDamageType.setId(damageTy.getId());
            vehicleDamageType.setKeyName(damageTy.getKeyName());
            vehicleDamageType.setDescription(damageTy.getDescription());
            damageTypeRepository.save(vehicleDamageType);
        }

        for (int i = 0; i < 20; i++) {
            var id = String.valueOf(i);
            Dealer dealer = new Dealer();
            dealer.setDealerId(id);
            dealer.setDealerName(id + "Birmot");
            dealerRepository.save(dealer);
        }
    }
}
