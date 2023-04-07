package com.tofas.vehicleExpertize.model.dto.request;

import lombok.Data;

@Data
public class VehicleEquipmentRequest {
    private String keyName;
    private String typeName;
    private String valueName;
    private String state;
}
