package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaGetFilesInfoResponse {
    private String requestId;
    @JsonProperty("files")
    private List<AutorolaFile> autorolaFiles;
}
