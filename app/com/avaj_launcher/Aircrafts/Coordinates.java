package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Exceptions.AircraftNeedLandingException;
import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;

public class Coordinates {
    private final int longitude;
    private final int latitude;
    private final int height;

    Coordinates(int valueOfLongitude, int valueOfLatitude, int valueOfHeight) throws OnlyPositiveCoordinatesValueException {
        if (valueOfHeight > 100) {
            valueOfHeight = 100;
        }

        this.longitude = valueOfLongitude;
        this.latitude = valueOfLatitude;
        this.height = valueOfHeight;

        if (this.longitude < 0 || this.latitude < 0) {
            throw new OnlyPositiveCoordinatesValueException();
        }
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }
}
