package com.avaj_launcher.Aircrafts;

import com.avaj_launcher.Color;
import com.avaj_launcher.Weathers.WeatherTower;

public abstract class Aircraft implements Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected Color color;
    protected WeatherTower weatherTower;

    protected Aircraft(long valueOfId, String valueOfName, Coordinates valueOfCoordinates) {
        this.name = valueOfName;
        this.coordinates = valueOfCoordinates;
        this.id = valueOfId;
        this.color = Color.getRandomColor();
    }

    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
        weatherTower.register(this);
        System.out.println(this.color + "Tower says: " + this.name + "(" + this.id + ")" + " registered to weather tower." + Color.RESET);
    }
}
