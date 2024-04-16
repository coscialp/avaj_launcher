package com.avaj_launcher.Exceptions;

public class AircraftNeedLandingException extends Exception {
    public AircraftNeedLandingException() {
        super("Aircraft need to land");
    }
}
