package dpozinen.aircraft;

import dpozinen.flyable.Flyable;
import dpozinen.io.FWriter;
import dpozinen.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	private String [] phrases = {
		"This is hot.", // hot
		"It's raining", // rain
		"Can't see shit.", // fog
		"My rotor is going to freeze!" // snow
	};

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	// called when being notified
	public void updateConditions() {
		int weatherIndex = weatherToInt(weatherTower.getWeather(coordinates));
		if (weatherIndex == 0)
			coordinates.increaseCoordinates(10, 0, 2); // sun
		else if (weatherIndex == 1)
			coordinates.increaseCoordinates(5, 0, 0); // rain
		else if (weatherIndex == 2)
			coordinates.increaseCoordinates(1, 0, 0); // fog
		else
			coordinates.increaseCoordinates(1, 0, -12); // snow
		checkBounds();
		FWriter.write(this + phrases[weatherIndex]);
		if (coordinates.getHeight() <= 0)
			weatherTower.unregister(this);
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}

	@Override
	public String toString() {
		return "Helicopter" + super.toString() + " ";
	}
}