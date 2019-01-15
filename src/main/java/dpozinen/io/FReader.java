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
	
	private ArrayList<String> read() throws Exception {
		Path path = Paths.get("scenario.txt");
		return (ArrayList<String>) Files.readAllLines(path);
	}

	private boolean isValidLine(String s, String [] split) {

		return true;
	}

	private boolean isValid(ArrayList <String> linesList, WeatherTower weatherTower) {
		if (linesList.isEmpty() || linesList.size() <= 1) 
			return false;
		if (Integer.parseInt(linesList.get(0)) < 0)
			return false;
		String [] split = new String[5];
		for (int i = 1; i < linesList.size(); i++) {
			if (!isValidLine(linesList.get(i), split))
				return false;
			aircraftFactory
			.newAircraft(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4])) // TODO: refactor
			.registerTower(weatherTower);
			Arrays.fill(split, null); // necessary?
		}
		return true;
	}

	public void readAndValidate(WeatherTower weatherTower, String fileName) throws Exception {
		ArrayList <String> linesList = read();
		for (String s : linesList) {
			System.out.println(s);
		}
		if (!isValid(linesList, weatherTower))
			throw new IllegalArgumentException("Invalid Input");
		
		// aircraftFactory.newAircraft("Baloon", "B1", 0, 0, 10).registerTower(weatherTower);
		// aircraftFactory.newAircraft("Jetplane", "J1", 0, 0, 0).registerTower(weatherTower);
		// aircraftFactory.newAircraft("Helicopter", "H1", 0, 0, 0).registerTower(weatherTower);
	}
	
	public int getSymCycles() {
		return symCycles;
	}
	
}