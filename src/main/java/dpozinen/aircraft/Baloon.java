package dpozinen.aircraft;

import dpozinen.flyable.Flyable;
import dpozinen.io.FWriter;
import dpozinen.tower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	private String [] phrases = {
		"Let's enjoy the good weather and take some pics.", //hot
		"Damn you rain! You messed up my baloon.", // rain
		"The fuck is this fog.", // fog
		"It's snowing. We're gonna crash." // snow
	};

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	// called when being notified
	public void updateConditions() {
		int weatherIndex = weatherToInt(weatherTower.getWeather(coordinates));
		if (weatherIndex == 0)
			coordinates.increaseCoordinates(2, 0, 4); // sun
		else if (weatherIndex == 1)
			coordinates.increaseCoordinates(0, 0, -5); // rain
		else if (weatherIndex == 2)
			coordinates.increaseCoordinates(0, 0, -3); // fog
		else
			coordinates.increaseCoordinates(0, 0, -15); // snow
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
		return "Baloon" + super.toString() + " ";
	}
}