package com.avaj_launcher.Presenter;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FilePresenter implements Presenter {
    private static FilePresenter instance = null;
    private final RandomAccessFile reader;

    private FilePresenter() throws IOException {
        this.reader = new RandomAccessFile("simulation.txt", "rw");
        this.reader.setLength(0);
    }

    public static FilePresenter getInstance() throws IOException {
        if (instance == null) {
            instance = new FilePresenter();
        }
        return instance;
    }

    public void log(String message) throws IOException {
        String formattedMessage = message.replaceAll("\u001B\\[[;\\d]*m", "");
        reader.writeBytes(formattedMessage + "\n");
    }
}
