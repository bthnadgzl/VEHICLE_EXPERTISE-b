package com.tofas.vehicleExpertize.model.FYA;

import lombok.Data;

@Data
public class ValuationResult {
    public String carId;
    public int valuationStatus;
    public String valuationDate;
    public String valuationAmount;
}
