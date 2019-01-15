package dpozinen.simulator;

import dpozinen.tower.Tower;
import dpozinen.tower.WeatherTower;

public class Simulator {
	private Tower	weatherTower;
	private int		simulationCycles;

	void read() {
		FReader reader = new FReader();
		weatherTower = new WeatherTower();
		reader.readAndValidate(weatherTower);
		simulationCycles = reader.getSymCycles();
	}
	
	void run() {
		FWriter.create();

	}
}