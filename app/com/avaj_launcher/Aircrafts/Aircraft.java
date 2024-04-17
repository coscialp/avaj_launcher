package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Color;
import com.avaj_launcher.Presenter.FilePresenter;
import com.avaj_launcher.Presenter.Presenter;
import com.avaj_launcher.Weathers.WeatherTower;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class Aircraft implements Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected Color color;
    protected WeatherTower weatherTower;

    protected Presenter presenter = null;

    protected Aircraft(long valueOfId, String valueOfName, Coordinates valueOfCoordinates, Presenter refOfPresenter) {
        this.name = valueOfName;
        this.coordinates = valueOfCoordinates;
        this.id = valueOfId;
        this.color = Color.getRandomColor();
        this.presenter = refOfPresenter;
    }

    public void registerTower(WeatherTower tower) throws IOException {
        this.weatherTower = tower;
        weatherTower.register(this);
        this.presenter.log(this.color + "Tower says: " + this.name + "(" + this.id + ")" + " registered to weather tower." + Color.RESET);
    }
}
