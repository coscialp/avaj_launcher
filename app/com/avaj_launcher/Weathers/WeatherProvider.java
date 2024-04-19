package com.avaj_launcher.Weathers;

import com.avaj_launcher.Aircrafts.Coordinates;

public class WeatherProvider {
    private final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    private static class Holder {
        private static final WeatherProvider INSTANCE = new WeatherProvider();
    }

    public static WeatherProvider getWeatherProvider() {
        return Holder.INSTANCE;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int weatherIndex = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % weather.length;
        return weather[weatherIndex];
    }
}
