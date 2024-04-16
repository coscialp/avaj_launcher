package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Color;
import com.avaj_launcher.Exceptions.AircraftNeedLandingException;
import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;

public class Helicopter extends Aircraft {

    public Helicopter(long valueOfId, String valueOfName, Coordinates valueOfCoordinates) {
        super(valueOfId, valueOfName, valueOfCoordinates);
    }

    public void updateConditions() throws OnlyPositiveCoordinatesValueException {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 10,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() + 2
                );
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 5,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight()
                );
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 1,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight()
                );
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 12
                );
                break;
        }
        System.out.println(this.color + "Helicopter#" + this.name + "(" + this.id + "): " + this.weatherTower.messageByWeather(weather) + Color.RESET);
        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.land(this);
            System.out.println(this.color + "Helicopter#" + this.name + "(" + this.id + ") landing." + Color.RESET);
            System.out.println(this.color + "Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower." + Color.RESET);
        }
    }
}
