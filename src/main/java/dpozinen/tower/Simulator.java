package dpozinen.tower;

import dpozinen.io.*;

public class Simulator {
	private WeatherTower weatherTower;
	private int		simulationCycles;

	public void read(String [] args) {
		FReader reader = new FReader();
		weatherTower = new WeatherTower();

		FWriter.create();
		try {
			reader.readAndValidate(weatherTower, args[0]); 
			simulationCycles = reader.getSymCycles();
		} catch (Exception e) {
			System.err.println("Error reading file");
		}
	}
	
	public void run() {
		for (int i = 0; i < simulationCycles; i++) {
			weatherTower.changeWeather();
		}
	}
}