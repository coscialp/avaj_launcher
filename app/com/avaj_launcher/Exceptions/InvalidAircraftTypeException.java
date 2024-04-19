package com.avaj_launcher.Exceptions;

public class InvalidAircraftTypeException extends Exception {
    private static final String INVALID_TYPE_MSG_TEMPLATE = "Invalid aircraft type: %s. Valid types are: Baloon, JetPlane, Helicopter";

    public InvalidAircraftTypeException(String type) {
        super(String.format(INVALID_TYPE_MSG_TEMPLATE, type));
    }
}
