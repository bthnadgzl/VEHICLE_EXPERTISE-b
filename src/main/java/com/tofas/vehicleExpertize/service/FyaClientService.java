package com.tofas.vehicleExpertize.service;

import com.tofas.vehicleExpertize.model.FYA.ValuationResult;

public interface FyaClientService {
    String login();

    boolean sendValuationResultToFya(ValuationResult valuationResult,String token);
}
