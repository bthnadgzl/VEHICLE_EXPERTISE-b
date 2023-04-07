package com.tofas.vehicleExpertize.model.autorola.expertiseXmlFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AutorolaXMLFileResponse implements Serializable {
    private static final long serialVersionUID = -2886983948842396054L;

    @JsonProperty("xmlcar")
    private XMLFileData xmlFileData;

    private String autorolaXmlFileUrl;

}
