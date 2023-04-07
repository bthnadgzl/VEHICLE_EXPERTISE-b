package com.tofas.vehicleExpertize.service;

import com.tofas.vehicleExpertize.model.dto.request.ExpertiseOfferRequest;
import com.tofas.vehicleExpertize.model.dto.response.ExpertiseOfferResponse;

public interface ExpertiseOfferService {
    ExpertiseOfferResponse updateExpertiseOffer(Long offerId, ExpertiseOfferRequest expertiseOfferRequest ) throws Exception;
}
