package com.avaj_launcher.Exceptions;

public class InvalidAircraftTypeException extends Exception {
    public InvalidAircraftTypeException(String type) {
        super("Invalid aircraft type: " + type + ". Valid types are: Baloon, JetPlane, Helicopter");
    }
}
