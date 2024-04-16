package com.avaj_launcher.Weathers;

import com.avaj_launcher.Aircrafts.Coordinates;

public class WeatherProvider {
    private static WeatherProvider instance = null;
    private final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getWeatherProvider() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int weatherIndex = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
        return weather[weatherIndex];
    }

}
