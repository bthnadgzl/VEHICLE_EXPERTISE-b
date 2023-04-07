package com.tofas.vehicleExpertize.model.autorola;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tofas.vehicleExpertize.model.autorola.vehicle.AutorolaMiscDate;
import com.tofas.vehicleExpertize.model.autorola.vehicle.AutorolaMiscPrice;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorolaMiscPriceResponse implements Serializable {
    private static final long serialVersionUID = -7119323059524850370L;
    @JsonProperty("carId")
    private Integer vehicleId;

    @JsonProperty("miscPrice1")
    private AutorolaMiscPrice autorolaMiscPrice;

    @JsonProperty("miscDates1")
    private AutorolaMiscDate autorolaMiscDate;

}
