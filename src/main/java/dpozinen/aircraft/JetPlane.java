package dpozinen.aircraft;

import dpozinen.flyable.Flyable;
import dpozinen.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	public void updateConditions() {

	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}

	@Override
	public String toString() {
		return "JetPlane" + super.toString();
	}
}