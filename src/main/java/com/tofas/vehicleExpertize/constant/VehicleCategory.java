package com.tofas.vehicleExpertize.constant;

public enum VehicleCategory {

    CAR("BINEK"),
    VAN("TICARI"),
    UNDEFINED("TANIMSIZ");

    private String description;

    VehicleCategory(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    }
