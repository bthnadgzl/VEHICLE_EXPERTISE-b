package com.tofas.vehicleExpertize.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendValuationResponse implements Serializable {
    private static final long serialVersionUID = 2960037729824225556L;

    @JsonProperty("message")
    private String message;

}
