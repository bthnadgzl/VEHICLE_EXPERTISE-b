package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.damage.AutorolaDamages;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.equipment.AutorolaVehicleEquipment;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.general.AutorolaVehicleGeneralData;
import com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile.picture.AutorolaVehiclePictures;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class XMLFileData implements Serializable {
    private static final long serialVersionUID = 3271137449519303619L;

    @JsonProperty("companyId")
    private Integer AutorolaCompanyId;

    @JsonProperty("data")
    private AutorolaVehicleGeneralData vehicleData;

    @JsonProperty("condition")
    private AutorolaVehicleCondition condition;
    @JsonProperty("damages")
    private AutorolaDamages autorolaDamages;

    @JsonProperty("equipment")
    private AutorolaVehicleEquipment autorolaVehicleEquipment;

    @JsonProperty("pictures")
    private AutorolaVehiclePictures autorolaVehiclePictures;

    @JsonProperty("reports")
    private AutorolaReports autorolaReports;

}
