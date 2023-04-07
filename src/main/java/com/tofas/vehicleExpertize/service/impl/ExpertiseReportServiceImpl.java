package com.tofas.vehicleExpertize.service.impl;

import com.tofas.vehicleExpertize.model.dto.response.VehicleExpertiseFilterResponse;
import com.tofas.vehicleExpertize.repository.VehicleExpertiseRepository;
import com.tofas.vehicleExpertize.repository.VehicleRepository;
import com.tofas.vehicleExpertize.service.ExpertiseReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ExpertiseReportServiceImpl implements ExpertiseReportService {

    private VehicleRepository vehicleRepository;
    private VehicleExpertiseRepository vehicleExpertiseRepository;

    @Override
    public List<String> getModels() {
        return vehicleRepository.findModels();
    }

    @Override
    public List<String> getBrands() {
        return vehicleRepository.findBrands();
    }

    @Override
    public List<String> getCategories() {
        return vehicleRepository.findCategories();
    }

    @Override
    public List<String> getBodyTypes() {
        return vehicleRepository.findBodyTypes();
    }


    @Override
    public List<VehicleExpertiseFilterResponse> getVehicleExpertiseReports() {
        return vehicleExpertiseRepository.getVehicleExpertiseReports();
    }


}
