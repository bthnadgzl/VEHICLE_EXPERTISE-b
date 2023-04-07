package com.tofas.vehicleExpertize.exception.autorolaExceptions;

import org.springframework.http.HttpStatusCode;

public class FyaValuationException extends RuntimeException {

    private HttpStatusCode status;

    public FyaValuationException(HttpStatusCode httpStatus) {
        this.status = httpStatus;
    }

}
