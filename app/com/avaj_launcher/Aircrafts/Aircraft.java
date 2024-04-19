package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Color;
import com.avaj_launcher.Presenter.Presenter;
import com.avaj_launcher.Weathers.WeatherTower;

import java.io.IOException;

public abstract class Aircraft implements Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected Color color;
    protected WeatherTower weatherTower;

    protected Presenter presenter;

    protected Aircraft(long id, String name, Coordinates coordinates, Presenter presenter) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = id;
        this.color = Color.getRandomColor();
        this.presenter = presenter;
    }

    public void registerTower(WeatherTower tower) throws IOException {
        this.weatherTower = tower;
        weatherTower.register(this);
        this.presenter.writeLog(this.color + "Tower says: " + this.name + "(" + this.id + ")" + " registered to weather tower." + Color.RESET);
    }
}
