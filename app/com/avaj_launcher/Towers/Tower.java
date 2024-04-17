package com.avaj_launcher.Towers;

import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;
import com.avaj_launcher.Aircrafts.Flyable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tower {
    List<Flyable> observers = new ArrayList<>();
    List<Flyable> landed = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    public void land(Flyable flyable) {
        landed.add(flyable);
    }

    protected void conditionsChanged() throws OnlyPositiveCoordinatesValueException, IOException {
        for (Flyable flyable : observers) {
           flyable.updateConditions();
        }

        for (Flyable flyable : landed) {
            this.unregister(flyable);
        }

        landed.clear();
    }
}
