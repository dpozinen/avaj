package dpozinen.tower;

import dpozinen.aircraft.Coordinates;
import dpozinen.weather.WeatherProvider;

public class WeatherTower extends Tower {
	
	// creates new weather conditions
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}
	
	// triggers notifying observers
	void changeWeather() {
		conditionsChanged();
	} 
}