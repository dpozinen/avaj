package dpozinen.flyable;

import dpozinen.tower.WeatherTower;

public interface Flyable {
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
}