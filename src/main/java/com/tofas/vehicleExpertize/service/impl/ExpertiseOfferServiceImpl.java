package com.tofas.vehicleExpertize.service.impl;

import com.tofas.vehicleExpertize.model.dto.request.ExpertiseOfferRequest;
import com.tofas.vehicleExpertize.model.dto.response.ExpertiseOfferResponse;
import com.tofas.vehicleExpertize.repository.ExpertiseOfferRepository;
import com.tofas.vehicleExpertize.service.ExpertiseOfferService;
import com.tofas.vehicleExpertize.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpertiseOfferServiceImpl implements ExpertiseOfferService {
    private final ExpertiseOfferRepository expertiseOfferRepository;
    private final Mapper mapper;

    @Override
    public ExpertiseOfferResponse updateExpertiseOffer(Long offerId, ExpertiseOfferRequest expertiseOfferRequest) throws Exception {
        var optionalOfferEntity = expertiseOfferRepository.findById(offerId);
        if (!optionalOfferEntity.isPresent())
            System.out.println("Exception");
        var offerEntity = optionalOfferEntity.get();

        mapper.mapSourceToTargetForExistingObject(expertiseOfferRequest, offerEntity);
        var savedEntity = expertiseOfferRepository.save(offerEntity);
        return mapper.mapSourceToTarget(savedEntity, ExpertiseOfferResponse.class);
    }
}
