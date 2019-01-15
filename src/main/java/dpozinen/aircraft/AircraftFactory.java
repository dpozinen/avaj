package dpozinen.aircraft;

import dpozinen.flyable.Flyable;

public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.equalsIgnoreCase("Baloon"))
			return new Baloon(name, coordinates);
		if (type.equalsIgnoreCase("JetPlane"))
			return new Baloon(name, coordinates);
		if (type.equalsIgnoreCase("Helicopter"))
			return new Baloon(name, coordinates);
		return null;
	}
}