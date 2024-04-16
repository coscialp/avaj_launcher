package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;
import com.avaj_launcher.Weathers.WeatherTower;

public interface Flyable {
    void updateConditions() throws OnlyPositiveCoordinatesValueException;

    void registerTower(WeatherTower weatherTower);
}
