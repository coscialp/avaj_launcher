package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;
import com.avaj_launcher.Weathers.WeatherTower;

import java.io.IOException;

public interface Flyable {
    void updateConditions() throws OnlyPositiveCoordinatesValueException, IOException;

    void registerTower(WeatherTower weatherTower) throws IOException;
}
