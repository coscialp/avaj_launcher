package com.avaj_launcher.Weathers;

import com.avaj_launcher.Aircrafts.Coordinates;
import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;
import com.avaj_launcher.Towers.Tower;

import java.io.IOException;
import java.util.Map;

public class WeatherTower extends Tower {
    private static final Map<String, String> weatherMessages = Map.of(
            "RAIN", "It's raining.",
            "FOG", "It's foggy.",
            "SUN", "It's sunny.",
            "SNOW", "It's snowing."
    );

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() throws OnlyPositiveCoordinatesValueException, IOException {
        this.conditionsChanged();
    }

    public String messageByWeather(String weather) {
        return weatherMessages.getOrDefault(weather, "Unknown weather");
    }
}
