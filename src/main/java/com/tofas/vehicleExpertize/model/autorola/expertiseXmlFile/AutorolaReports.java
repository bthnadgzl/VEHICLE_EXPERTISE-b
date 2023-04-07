package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaReports implements Serializable {

    @JsonProperty("report")
    private String expertiseReportUrl;
}
