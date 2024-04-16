package com.avaj_launcher;

import com.avaj_launcher.Aircrafts.*;
import com.avaj_launcher.Exceptions.InvalidAircraftTypeException;
import com.avaj_launcher.Exceptions.OnlyPositiveCoordinatesValueException;
import com.avaj_launcher.Weathers.WeatherTower;

import java.io.IOException;
import java.util.List;

public class Simulator {
    private static void writeUsage() {
        System.out.println("Usage:\tjava com.avaj_launcher.Simulator scenario.txt");
        System.out.println("=====================================================");
        System.out.println("scenario.txt: file containing the simulation scenario");
        System.out.println("The first line of the file must be a positive integer representing the number of times the simulation must be run");
        System.out.println("Each following line must contain data for an aircraft in the following format: TYPE NAME LONGITUDE LATITUDE HEIGHT");
    }

    private static WeatherTower getWeatherTowerAndRegisterAllAircraft(List<String> lines) throws InvalidAircraftTypeException, OnlyPositiveCoordinatesValueException {
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory aircraftFactory = AircraftFactory.getInstance();

        for (int i = 1; i < lines.size(); i++) {
            String[] aircraftData = lines.get(i).split(" ");
            Flyable aircraft = aircraftFactory.newAircraft(
                    aircraftData[0],
                    aircraftData[1],
                    Integer.parseInt(aircraftData[2]),
                    Integer.parseInt(aircraftData[3]),
                    Integer.parseInt(aircraftData[4])
            );
            aircraft.registerTower(weatherTower);
        }
        return weatherTower;
    }

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                writeUsage();
                return;
            }

            List<String> lines = ScenarioParser.parse(args);
            int nbOfSimulations = Integer.parseInt(lines.get(0));
            WeatherTower weatherTower = getWeatherTowerAndRegisterAllAircraft(lines);

            for (int i = 0; i < nbOfSimulations; i++) {
                weatherTower.changeWeather();
            }
        } catch (IllegalArgumentException | IOException | InvalidAircraftTypeException |
                 OnlyPositiveCoordinatesValueException e) {
            System.out.println(Color.RED + "Error: " + e.getClass().getSimpleName() + " - " + e.getMessage() + Color.RESET);
        } catch (Exception e) {
            System.out.println(Color.RED + "Error: unknown error occurred\n" + e.fillInStackTrace() + Color.RESET);
        }
    }
}