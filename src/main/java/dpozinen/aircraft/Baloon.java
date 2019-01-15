package dpozinen.aircraft;

import dpozinen.flyable.Flyable;
import dpozinen.tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	public void updateConditions() {
		// called when notifying
	}

	public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
	}

	@Override
	public String toString() {
		return "Baloon" + super.toString();
	}
}