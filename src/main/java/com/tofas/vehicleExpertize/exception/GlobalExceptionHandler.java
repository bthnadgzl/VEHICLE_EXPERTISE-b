package com.tofas.vehicleExpertize.exception;

import com.tofas.vehicleExpertize.exception.autorolaExceptions.AutorolaLoginException;
import com.tofas.vehicleExpertize.exception.autorolaExceptions.FyaTokenException;
import com.tofas.vehicleExpertize.exception.autorolaExceptions.FyaValuationException;
import com.tofas.vehicleExpertize.model.dto.ServiceResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static com.tofas.vehicleExpertize.model.dto.ServiceResponseDTO.fail;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String AUTOROLA_UNAUTHORIZE_MESSAGE = "Please check username or password(credential info) !!";
    private static final String AUTOROLA_OTHER_MESSAGE = "An any error occured when login to autorola !!";
    private static final String FYA_VALUATION_EXCEPTION_MESSAGE = "An any error occured when send valuation to fya !!";
    private static final String FYA_TOKEN_EXCEPTION_MESSAGE = "An any error occured when login to fya !!";

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ServiceResponseDTO> sqlIntegrityConstraintViolationException(EntityNotFoundException ex) {
        return new ResponseEntity<>(fail(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase(), ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {AutorolaLoginException.class})
    public ResponseEntity<ServiceResponseDTO> httpClientErrorException(AutorolaLoginException ex, WebRequest request) {
        String message;
        if (ex.getStatus() == HttpStatus.UNAUTHORIZED)
            message = AUTOROLA_UNAUTHORIZE_MESSAGE;
        else
            message = AUTOROLA_OTHER_MESSAGE;

        return new ResponseEntity<>(fail(ex.getStatus().toString(), message), ex.getStatus());
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ServiceResponseDTO> illegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        return new ResponseEntity<>(fail(HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {FyaTokenException.class})
    public ResponseEntity<ServiceResponseDTO> fyaTokenException() {
        return new ResponseEntity<>(fail(HttpStatus.UNAUTHORIZED.getReasonPhrase(), FYA_TOKEN_EXCEPTION_MESSAGE), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {FyaValuationException.class})
    public ResponseEntity<ServiceResponseDTO> fyaValuationException(FyaValuationException ex, WebRequest request) {
        return new ResponseEntity<>(fail(ex.getMessage(), FYA_VALUATION_EXCEPTION_MESSAGE), null);

    }

}
