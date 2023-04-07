package com.tofas.vehicleExpertize.controller;

import com.tofas.vehicleExpertize.model.dto.ServiceResponseDTO;
import com.tofas.vehicleExpertize.model.dto.response.VehicleExpertiseFilterResponse;
import com.tofas.vehicleExpertize.service.ExpertiseReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tofas.vehicleExpertize.model.dto.ServiceResponseDTO.success;

@RestController
@RequestMapping(value = "/expertise")
@AllArgsConstructor
public class ExpertiseController {
    private final ExpertiseReportService expertiseReportService;

    @GetMapping("/reports")
    public ServiceResponseDTO<List<VehicleExpertiseFilterResponse>> getExpertiseReport(){
        var response = expertiseReportService.getVehicleExpertiseReports();
        return success(response);
    }
}
