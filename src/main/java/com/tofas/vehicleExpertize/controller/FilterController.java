package com.tofas.vehicleExpertize.controller;

import com.tofas.vehicleExpertize.model.dto.ServiceResponseDTO;
import com.tofas.vehicleExpertize.model.dto.response.DealerResponse;
import com.tofas.vehicleExpertize.service.DealerService;
import com.tofas.vehicleExpertize.service.ExpertiseReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tofas.vehicleExpertize.model.dto.ServiceResponseDTO.success;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/filter")
public class FilterController {

    public ExpertiseReportService expertiseReportService;
    public DealerService dealerService;
    @GetMapping(value = "/models")
    public ServiceResponseDTO<List<String>> getModels(){
        return success(expertiseReportService.getModels());
    }
    @GetMapping(value = "/brands")
    public ServiceResponseDTO<List<String>> getBrandList(){
        return success(expertiseReportService.getBrands());
    }
    @GetMapping(value = "/categories")
    public ServiceResponseDTO<List<String>> getCategoryList(){
        return success(expertiseReportService.getCategories());
    }
    @GetMapping(value = "/body-types")
    public ServiceResponseDTO<List<String>> getBodyList(){
        return success(expertiseReportService.getBodyTypes());
    }
    @GetMapping("/dealers")
    public ServiceResponseDTO<List<DealerResponse>> getDealerList() {
        var response = dealerService.gerDealerList();
        return success(response);
    }
}
