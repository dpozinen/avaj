package dpozinen.aircraft;

import dpozinen.flyable.Flyable;
import dpozinen.tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	
	private Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	public void updateConditions() {

	}

	public void registerTower(WeatherTower weatherTower) {

	}

	@Override
	public String toString() {
		return "Baloon" + super.toString();
	}
}