package dpozinen.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dpozinen.aircraft.AircraftFactory;
import dpozinen.tower.WeatherTower;

import java.util.ArrayList;
import java.util.Arrays;

public class FReader {
	private int symCycles;
	private AircraftFactory aircraftFactory = new AircraftFactory();

	private ArrayList<String> read(String filename) throws Exception {
		Path path = Paths.get(filename);
		return (ArrayList<String>) Files.readAllLines(path);
	}

	private boolean isValid(ArrayList <String> linesList, WeatherTower weatherTower) {
		try {
			if (linesList.isEmpty() || linesList.size() <= 1)
				return false;
			symCycles = Integer.parseInt(linesList.get(0));
			if (symCycles < 0)
				return false;

			String [] split;
			for (int i = 1; i < linesList.size(); i++) {
				split = linesList.get(i).split(" ");
				aircraftFactory
				.newAircraft(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]))
				.registerTower(weatherTower);
				Arrays.fill(split, null);
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Non numeric input");
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}
		return true;
	}

	public void readAndValidate(WeatherTower weatherTower, String fileName) throws Exception {
		ArrayList <String> linesList = read(fileName);
		if (!isValid(linesList, weatherTower))
			throw new IllegalArgumentException("Invalid Input");
	}

	public int getSymCycles() {
		return symCycles;
	}

}