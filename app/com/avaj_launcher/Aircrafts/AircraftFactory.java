package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Exceptions.InvalidAircraftTypeException;
import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;
import com.avaj_launcher.Presenter.Presenter;

import java.util.UUID;

public class AircraftFactory {
    private static AircraftFactory instance = null;

    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height, Presenter presenter) throws InvalidAircraftTypeException, OnlyPositiveCoordinatesValueException {
        long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        return switch (type) {
            case "Baloon" -> new Balloon(id, name, coordinates, presenter);
            case "JetPlane" -> new JetPlane(id, name, coordinates, presenter);
            case "Helicopter" -> new Helicopter(id, name, coordinates, presenter);
            default -> throw new InvalidAircraftTypeException(type);
        };
    }
}
