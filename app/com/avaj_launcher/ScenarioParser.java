package com.avaj_launcher;

import com.avaj_launcher.Aircrafts.Flyable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class ScenarioParser {
    public static List<String> parse(String[] args) throws IllegalArgumentException, FileNotFoundException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        List<String> lines = new ArrayList<String>();
        List<String[]> aircraftData = new ArrayList<String[]>();

        try (RandomAccessFile reader = new RandomAccessFile(args[0], "r")) {
            while (reader.getFilePointer() < reader.length()) {
                lines.add(reader.readLine());
            }

            if (lines.isEmpty()) {
                throw new IllegalArgumentException("Invalid scenario file");
            }

            try {
                if (Integer.parseInt(lines.get(0).split(" ")[0]) <= 0) {
                    throw new IllegalArgumentException("Invalid scenario file. First line must be a positive integer representing the number of times the simulation must be run");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid scenario file. First line must be a positive integer representing the number of times the simulation must be run");
            }

            for (int i = 1; i < lines.size(); i++) {
                aircraftData.add(lines.get(i).split(" "));
                if (aircraftData.get(i - 1).length != 5) {
                    throw new IllegalArgumentException("Invalid aircraft data");
                }
            }

            return lines;

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Scenario file not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
