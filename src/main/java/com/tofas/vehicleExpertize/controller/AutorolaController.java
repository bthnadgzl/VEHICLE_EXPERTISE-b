package com.tofas.vehicleExpertize.controller;

import com.tofas.vehicleExpertize.model.autorola.AutorolaEvent;
import com.tofas.vehicleExpertize.model.dto.ServiceResponseDTO;
import com.tofas.vehicleExpertize.model.dto.request.VehicleExpertiseRequest;
import com.tofas.vehicleExpertize.model.dto.response.VehicleExpertiseResponse;
import com.tofas.vehicleExpertize.service.VehicleExpertiseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

import static com.tofas.vehicleExpertize.model.dto.ServiceResponseDTO.success;

@RestController
@AllArgsConstructor
public class AutorolaController {
    private final VehicleExpertiseService vehicleExpertiseService;

    private static final String SINGLETON_MAP_KEY = "result";

    @PostMapping(value = "/webhook")
    public ServiceResponseDTO<VehicleExpertiseResponse> createVehicleExpertise(@RequestBody VehicleExpertiseRequest vehicleExpertiseRequest) throws Exception {
        var response = vehicleExpertiseService.createVehicleExpertiseData(vehicleExpertiseRequest.getVehicleId());
        return success(response);
    }

    @PostMapping(value = "/result")
    public ServiceResponseDTO<ResponseEntity<Object>> expertiseResult(@RequestBody Optional<AutorolaEvent> event) {
        if (!event.isPresent())
            return success(ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap(SINGLETON_MAP_KEY, false)));

        int carId = event.get().getEntityId();
        var result = vehicleExpertiseService.sendValuationToFya(carId);
        return success(ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap(SINGLETON_MAP_KEY, result))) ;
    }
}
