package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Color;
import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;
import com.avaj_launcher.Presenter.Presenter;

import java.io.IOException;

public class JetPlane extends Aircraft {

    public JetPlane(long valueOfId, String valueOfName, Coordinates valueOfCoordinates, Presenter refOfPresenter) {
        super(valueOfId, valueOfName, valueOfCoordinates, refOfPresenter);
    }

    public void updateConditions() throws OnlyPositiveCoordinatesValueException, IOException {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 10,
                        this.coordinates.getHeight() + 2
                );
                break;
            case "RAIN":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 5,
                        this.coordinates.getHeight()
                );
                break;
            case "FOG":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude() + 1,
                        this.coordinates.getHeight()
                );
                break;
            case "SNOW":
                this.coordinates = new Coordinates(
                        this.coordinates.getLongitude(),
                        this.coordinates.getLatitude(),
                        this.coordinates.getHeight() - 7
                );
                break;
        }
        this.presenter.log(this.color + "JetPlane#" + this.name + "(" + this.id + "): " + this.weatherTower.messageByWeather(weather) + Color.RESET);
        if (this.coordinates.getHeight() <= 0) {
            this.weatherTower.land(this);
            this.presenter.log(this.color + "JetPlane#" + this.name + "(" + this.id + ") landing." + Color.RESET);
            this.presenter.log(this.color + "Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower." + Color.RESET);
        }
    }
}
