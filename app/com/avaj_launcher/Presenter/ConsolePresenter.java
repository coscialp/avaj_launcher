package com.avaj_launcher.Presenter;

import java.io.FileNotFoundException;

public class ConsolePresenter implements Presenter {
    private static ConsolePresenter instance = null;

    private ConsolePresenter() {
    }

    public static ConsolePresenter getInstance() throws FileNotFoundException {
        if (instance == null) {
            instance = new ConsolePresenter();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(message);
    }
}
