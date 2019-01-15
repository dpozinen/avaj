package dpozinen.weather;

import dpozinen.aircraft.Coordinates;

public class WeatherProvider {

	private static WeatherProvider	weatherProvider = null;
	private static String []		weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		if (weatherProvider == null)
			return weatherProvider = new WeatherProvider();
		return weatherProvider;
	}

	// generate new random weather
	public String getCurrentWeather(Coordinates coordinates) {
		return null;
	}
}