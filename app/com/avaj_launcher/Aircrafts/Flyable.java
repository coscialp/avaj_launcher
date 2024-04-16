package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Exceptions.AircraftNeedLandingException;
import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;
import com.avaj_launcher.Weathers.WeatherTower;

public interface Flyable {
    abstract public void updateConditions() throws OnlyPositiveCoordinatesValueException;
    abstract public void registerTower(WeatherTower weatherTower);
}
