package dpozinen.aircraft;

import dpozinen.flyable.Flyable;
import dpozinen.io.FWriter;
import dpozinen.tower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;
	private String [] frases = {
		"Ahh, that's hot.", // hot
		"It's raining. Better watch out for lightings.", // rain
		"Am I in England wtf.", // fog
		"OMG! Winter is coming!" // snow
	};

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}
	
	// called when being notified
	public void updateConditions() {
		int weatherIndex = weatherToInt(weatherTower.getWeather(coordinates));
		if (weatherIndex == 0)
			coordinates.increaseCoordinates(0, 10, 2);
		else if (weatherIndex == 1)
			coordinates.increaseCoordinates(0, 5, 0);
		else if (weatherIndex == 2)
			coordinates.increaseCoordinates(0, 1, 0);
		else
			coordinates.increaseCoordinates(0, 0, -7);
		checkBounds();
		FWriter.write(this + frases[weatherIndex]);
		if (coordinates.getHeight() == 0)
			weatherTower.unregister(this);
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}

	@Override
	public String toString() {
		return "JetPlane" + super.toString() + " ";
	}
}