package dpozinen.weather;

import java.util.Random;

import dpozinen.aircraft.Coordinates;

public class WeatherProvider {

	private static WeatherProvider	weatherProvider = null;
	private static String []		weather = {"RAIN", "FOG", "SUN", "SNOW"};
	private Random random = new Random();

	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		if (weatherProvider == null)
			return weatherProvider = new WeatherProvider();
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int h = coordinates.getHeight();
		int lo = coordinates.getLongitude();
		int la = coordinates.getLatitude();
		int coordinatesPart = h * lo * la;
		int num = random.nextInt(weather.length);
		int r = num + coordinatesPart >= weather.length ? num : num+coordinatesPart;

		return weather[r];
	}
}