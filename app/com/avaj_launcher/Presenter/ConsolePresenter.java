package com.avaj_launcher.Presenter;

public class ConsolePresenter implements Presenter {
    private static volatile ConsolePresenter instance = null;

    private ConsolePresenter() {
    }

    public static ConsolePresenter getInstance() {
        if (instance == null) {
            synchronized (ConsolePresenter.class) {
                if (instance == null) {
                    instance = new ConsolePresenter();
                }
            }
        }
        return instance;
    }

    public void writeLog(String message) {
        System.out.println(message);
    }
}
