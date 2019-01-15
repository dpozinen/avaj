package dpozinen.simulator;

import dpozinen.tower.Tower;
import dpozinen.tower.WeatherTower;
import dpozinen.weather.WeatherProvider;

public class Simulator {
	private Tower	weatherTower;
	private int		simulationCycles;

	public void read(String [] args) {
		FReader reader = new FReader();
		weatherTower = new WeatherTower();

		// opens file by name in args[0]; reads; validates; add to weatherTower List; stores number of cycles; throws exceptions
		reader.readAndValidate(weatherTower, args[0]); 
		simulationCycles = reader.getSymCycles();
	}
	
	public void run() {
		WeatherProvider weatherProvider = WeatherProvider.getProvider();
		FWriter.create();

		for (int i = 0; i < simulationCycles; i++)
			FWriter.write(weatherProvider.getCurrentWeather(null));
	}
}