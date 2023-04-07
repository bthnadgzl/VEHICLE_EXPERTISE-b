package com.tofas.vehicleExpertize.exception.autorolaExceptions;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
public class FyaLoginException extends RuntimeException {

    private HttpStatusCode status;

    public FyaLoginException(HttpStatusCode httpStatus) {
        this.status = httpStatus;
    }



}
