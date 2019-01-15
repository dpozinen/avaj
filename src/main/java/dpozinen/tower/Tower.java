package dpozinen.tower;

import java.util.ArrayList;
import java.util.List;

import dpozinen.flyable.Flyable;
import dpozinen.simulator.FWriter;

public class Tower {
	private List<Flyable> observers = new ArrayList<>();

	public void register(Flyable flyable) {
		observers.add(flyable);
		FWriter.write("Tower says: " + flyable + " registered to weather tower.");
	}
	
	public void unregister(Flyable flyable) {
		observers.remove(flyable);
		FWriter.write("Tower says: " + flyable + " unregistered from weather tower.");
	}

	protected void conditionsChanged() {
		for (Flyable f : observers)
			f.updateConditions();
	}
}