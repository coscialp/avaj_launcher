package com.avaj_launcher.Presenter;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FilePresenter implements Presenter {
    private static final String FILE_PATH = "simulation.txt";
    private static final String FILE_ACCESS_MODE = "rw";
    private static final String STRIP_ANSI_ESCAPE_CODES_REGEX = "\u001B\\[[;\\d]*m";

    private static volatile FilePresenter instance = null;
    private final RandomAccessFile fileWriter;

    private FilePresenter() throws IOException {
        this.fileWriter = new RandomAccessFile(FILE_PATH, FILE_ACCESS_MODE);
        this.fileWriter.setLength(0);
    }

    public static FilePresenter getInstance() throws IOException {
        if (instance == null) {
            synchronized (FilePresenter.class) {
                if (instance == null) {
                    instance = new FilePresenter();
                }
            }
        }
        return instance;
    }

    public void writeLog(String message) throws IOException {
        String formattedMessage = message.replaceAll(STRIP_ANSI_ESCAPE_CODES_REGEX, "");
        fileWriter.writeBytes(formattedMessage + "\n");
    }
}
