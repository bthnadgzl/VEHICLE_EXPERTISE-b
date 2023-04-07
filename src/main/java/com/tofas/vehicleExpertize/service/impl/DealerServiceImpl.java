package com.tofas.vehicleExpertize.service.impl;

import com.tofas.vehicleExpertize.model.dto.request.DealerRequest;
import com.tofas.vehicleExpertize.model.dto.response.DealerResponse;
import com.tofas.vehicleExpertize.model.entity.Dealer;
import com.tofas.vehicleExpertize.repository.DealerRepository;
import com.tofas.vehicleExpertize.service.DealerService;
import com.tofas.vehicleExpertize.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class DealerServiceImpl implements DealerService {

    private final DealerRepository dealerRepository;
    private final Mapper mapper;

    @Override
    public List<DealerResponse> gerDealerList() {
        List<Dealer> dealerEntityList = dealerRepository.findAll();
        return mapper.mapSourceListToTargetList(dealerEntityList, DealerResponse.class);
    }

    @Override
    public DealerResponse createDealer(DealerRequest dealerRequest) {
        Dealer dealerEntity = mapper.mapSourceToTarget(dealerRequest, Dealer.class);
        dealerEntity = dealerRepository.save(dealerEntity);
        return mapper.mapSourceToTarget(dealerEntity, DealerResponse.class);
    }
}
