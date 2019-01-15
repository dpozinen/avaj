package dpozinen.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import dpozinen.aircraft.AircraftFactory;
import dpozinen.tower.WeatherTower;

import java.util.ArrayList;

public class FReader {
	private int symCycles;
	private AircraftFactory aircraftFactory = new AircraftFactory();
	
	private ArrayList<String> read() throws Exception {
		Path path = Paths.get("scenario.txt");
		return (ArrayList<String>) Files.readAllLines(path);
	}

	public void readAndValidate(WeatherTower weatherTower, String fileName) throws Exception {
		
		ArrayList <String> linesList = read();
		for (String s : linesList) {
			System.out.println(s);
		}
		aircraftFactory.newAircraft("Baloon", "B1", 0, 0, 10).registerTower(weatherTower);
		aircraftFactory.newAircraft("Jetplane", "J1", 0, 0, 0).registerTower(weatherTower);
		aircraftFactory.newAircraft("Helicopter", "H1", 0, 0, 0).registerTower(weatherTower);
	}
	
	public int getSymCycles() {
		return symCycles;
	}
	
}