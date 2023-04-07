package com.tofas.vehicleExpertize.model.autorola;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaEvent {

    private Integer entityId;
    private String eventIdentifier;
    private String eventDate;
    private String eventName;
}
