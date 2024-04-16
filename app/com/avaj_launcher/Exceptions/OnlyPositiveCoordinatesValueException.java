package com.avaj_launcher.Exceptions;

public class OnlyPositiveCoordinatesValueException extends Exception {
    public OnlyPositiveCoordinatesValueException() {
        super("Coordinates values must be positive");
    }
}
