package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Color;
import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;
import com.avaj_launcher.Presenter.Presenter;

import java.io.IOException;

public class Balloon extends Aircraft {

    public Balloon(long valueOfId, String valueOfName, Coordinates valueOfCoordinates, Presenter refOfPresenter) {
        super(valueOfId, valueOfName, valueOfCoordinates, refOfPresenter);
    }

    public void updateConditions() throws OnlyPositiveCoordinatesValueException, IOException {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude() + 2,
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() + 4
                );
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 5
                );
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 3
                );
            case "SNOW":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 15
                );
                break;
        }
        this.presenter.writeLog(this.color + "Balloon#" + this.name + "(" + this.id + "): " + this.weatherTower.messageByWeather(weather) + Color.RESET);
        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.land(this);
            this.presenter.writeLog(this.color + "Balloon#" + this.name + "(" + this.id + ") landing." + Color.RESET);
            this.presenter.writeLog(this.color + "Tower says: Balloon#" + this.name + "(" + this.id + ") unregistered from weather tower." + Color.RESET);
        }
    }
}
