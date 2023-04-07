package com.tofas.vehicleExpertize.exception.autorolaExceptions;

public class AutorolaGetVehicleDataException extends RuntimeException {
    private final static String MESSAGE_TEXT = "";

    public AutorolaGetVehicleDataException(String message) {
        super(message);
    }

    public AutorolaGetVehicleDataException(Throwable cause) {
        super(MESSAGE_TEXT, cause);
    }


}
