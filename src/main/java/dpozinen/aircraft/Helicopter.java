package dpozinen.aircraft;

import dpozinen.flyable.Flyable;
import dpozinen.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	
	private Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	public void updateConditions() {

	}

	public void registerTower(WeatherTower weatherTower) {

	}
}