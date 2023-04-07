package com.tofas.vehicleExpertize.model.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ServiceResponseDTO<T> {
    HttpStatus httpStatus;
    private Boolean successful;
    private String errorCode;
    private String errorMessage;
    private T data;

    public static <T> ServiceResponseDTO<T> fail(String errorCode, String errorMessage) {
        ServiceResponseDTO<T> tServiceResponseDTO = new ServiceResponseDTO<>();
        tServiceResponseDTO.setHttpStatus(HttpStatus.OK);
        tServiceResponseDTO.setErrorMessage(errorMessage);
        tServiceResponseDTO.setErrorCode(errorCode);
        tServiceResponseDTO.setSuccessful(false);
        return tServiceResponseDTO;
    }

    public static <T> ServiceResponseDTO<T> success(T data) {
        ServiceResponseDTO<T> tServiceResponseDTO = new ServiceResponseDTO<>();
        tServiceResponseDTO.setHttpStatus(HttpStatus.OK);
        tServiceResponseDTO.setSuccessful(true);
        tServiceResponseDTO.setData(data);
        return tServiceResponseDTO;
    }
}
