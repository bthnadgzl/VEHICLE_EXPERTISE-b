package com.tofas.vehicleExpertize.exception.autorolaExceptions;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
public class AutorolaLoginException extends RuntimeException {

    private HttpStatusCode status;

    public AutorolaLoginException(HttpStatusCode httpStatus) {
        this.status = httpStatus;
    }

}
