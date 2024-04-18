package com.avaj_launcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class ScenarioParser {
    private static final int EXPECTED_NUM_ARGS = 2;
    private static final int EXPECTED_AIRCRAFT_DATA_SIZE = 5;
    private static final String CONSOLE_ARG = "-console";
    private static final String FILE_ARG = "-file";
    private static final String ERROR_FILE_NOT_FOUND = "Scenario file not found";
    private static final String ERROR_INVALID_NUM_ARGUMENTS = "Invalid number of arguments";
    private static final String ERROR_INVALID_ARGUMENT = "Invalid argument";
    private static final String ERROR_INVALID_SCENARIO_FILE = "Invalid scenario file";
    private static final String ERROR_BAD_SCENARIO_FILE_LINE_1 = "Invalid scenario file. First line must be a positive integer representing the number of times the simulation must be run";
    private static final String ERROR_INVALID_AIRCRAFT_DATA = "Invalid aircraft data";

    public static List<String> parse(String[] args) throws IllegalArgumentException, FileNotFoundException {
        validateArgs(args);

        try (RandomAccessFile reader = new RandomAccessFile(args[0], "r")) {
            List<String> lines = readFileLines(reader);
            validateAndParseLines(lines);
            return lines;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(ERROR_FILE_NOT_FOUND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void validateArgs(String[] args) {
        if (args.length != 1 && args.length != EXPECTED_NUM_ARGS) {
            throw new IllegalArgumentException(ERROR_INVALID_NUM_ARGUMENTS);
        }
        if (args.length == EXPECTED_NUM_ARGS && !args[1].equals(CONSOLE_ARG) && !args[1].equals(FILE_ARG)) {
            throw new IllegalArgumentException(ERROR_INVALID_ARGUMENT);
        }
    }

    private static List<String> readFileLines(RandomAccessFile reader) throws IOException {
        List<String> lines = new ArrayList<>();
        while (reader.getFilePointer() < reader.length()) {
            lines.add(reader.readLine());
        }
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INVALID_SCENARIO_FILE);
        }
        return lines;
    }

    private static void validateAndParseLines(List<String> lines) {
        try {
            if (Integer.parseInt(lines.get(0).split(" ")[0]) <= 0) {
                throw new IllegalArgumentException(ERROR_BAD_SCENARIO_FILE_LINE_1);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_BAD_SCENARIO_FILE_LINE_1);
        }
        for (int i = 1; i < lines.size(); i++) {
            String[] aircraftData = lines.get(i).split(" ");
            if (aircraftData.length != EXPECTED_AIRCRAFT_DATA_SIZE) {
                throw new IllegalArgumentException(ERROR_INVALID_AIRCRAFT_DATA);
            }
        }
    }
}
