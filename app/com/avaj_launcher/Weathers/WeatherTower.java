package com.avaj_launcher.Weathers;

import com.avaj_launcher.Aircrafts.Coordinates;
import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;
import com.avaj_launcher.Towers.Tower;

import java.io.IOException;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() throws OnlyPositiveCoordinatesValueException, IOException {
        this.conditionsChanged();
    }

    public String messageByWeather(String weather) {
        return switch (weather) {
            case "RAIN" -> "It's raining.";
            case "FOG" -> "It's foggy.";
            case "SUN" -> "It's sunny.";
            case "SNOW" -> "It's snowing.";
            default -> "Unknown weather.";
        };
    }
}
