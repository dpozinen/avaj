package dpozinen.aircraft;

import dpozinen.flyable.Flyable;
import dpozinen.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	
	private JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	public void updateConditions() {

	}

	public void registerTower(WeatherTower weatherTower) {

	}

	@Override
	public String toString() {
		return "JetPlane" + super.toString();
	}
}