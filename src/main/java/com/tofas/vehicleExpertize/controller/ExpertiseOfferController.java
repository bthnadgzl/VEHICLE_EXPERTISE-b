package com.tofas.vehicleExpertize.controller;

import com.tofas.vehicleExpertize.model.dto.ServiceResponseDTO;
import com.tofas.vehicleExpertize.model.dto.request.ExpertiseOfferRequest;
import com.tofas.vehicleExpertize.model.dto.response.ExpertiseOfferResponse;
import com.tofas.vehicleExpertize.service.ExpertiseOfferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/expertise-offer")
@AllArgsConstructor
public class ExpertiseOfferController {

    private final ExpertiseOfferService expertiseOfferService;

    @PutMapping("/{id}")
    public ServiceResponseDTO<ExpertiseOfferResponse> updateExpertiseOffer(@PathVariable Long id, @RequestBody ExpertiseOfferRequest expertiseOfferRequest) throws Exception {
        var response = expertiseOfferService.updateExpertiseOffer(id, expertiseOfferRequest);
        return ServiceResponseDTO.success(response);
    }
}
