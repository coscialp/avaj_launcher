package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Color;
import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;
import com.avaj_launcher.Presenter.Presenter;

import java.io.IOException;

public class Helicopter extends Aircraft {

    public Helicopter(long valueOfId, String valueOfName, Coordinates valueOfCoordinates, Presenter refOfPresenter) {
        super(valueOfId, valueOfName, valueOfCoordinates, refOfPresenter);
    }

    public void updateConditions() throws OnlyPositiveCoordinatesValueException, IOException {
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
        this.presenter.log(this.color + "Helicopter#" + this.name + "(" + this.id + "): " + this.weatherTower.messageByWeather(weather) + Color.RESET);
        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.land(this);
            this.presenter.log(this.color + "Helicopter#" + this.name + "(" + this.id + ") landing." + Color.RESET);
            this.presenter.log(this.color + "Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower." + Color.RESET);
        }
    }
}
