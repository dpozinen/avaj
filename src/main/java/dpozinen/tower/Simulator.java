package dpozinen.tower;

import dpozinen.io.*;

public class Simulator {
	private WeatherTower weatherTower;
	private int		simulationCycles;

	public void read(String [] args) {
		
		FReader reader = new FReader();
		weatherTower = new WeatherTower();

		FWriter.create();
		// opens file by name in args[0]; reads; validates; add to weatherTower List; stores number of cycles; throws exceptions
		try {
			reader.readAndValidate(weatherTower, args[0]); 
			simulationCycles = reader.getSymCycles();
		} catch (Exception e) {
			System.err.println("Error at read " + e);
		}
	}
	
	public void run() {
		for (int i = 0; i < simulationCycles; i++) {
			weatherTower.changeWeather();
		}
	}
}