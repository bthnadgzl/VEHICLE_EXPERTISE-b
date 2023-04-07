package com.tofas.vehicleExpertize.controller;

import com.tofas.vehicleExpertize.model.dto.ServiceResponseDTO;
import com.tofas.vehicleExpertize.model.dto.request.DealerRequest;
import com.tofas.vehicleExpertize.model.dto.response.DealerResponse;
import com.tofas.vehicleExpertize.service.DealerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tofas.vehicleExpertize.model.dto.ServiceResponseDTO.success;

@RestController
@RequestMapping(value = "/dealer")
@AllArgsConstructor
public class DealerController {
    private final DealerService dealerService;

    @PostMapping()
    public ServiceResponseDTO<DealerResponse> createDealer(@RequestBody DealerRequest dealerRequest) {
        var response = dealerService.createDealer(dealerRequest);
        return success(response);
    }

}
