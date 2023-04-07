package com.tofas.vehicleExpertize.service;

import com.tofas.vehicleExpertize.model.dto.request.DealerRequest;
import com.tofas.vehicleExpertize.model.dto.response.DealerResponse;

import java.util.List;

public interface DealerService {

    List<DealerResponse> gerDealerList();

    DealerResponse createDealer(DealerRequest dealerRequest);
}
