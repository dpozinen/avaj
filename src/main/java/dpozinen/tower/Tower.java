package dpozinen.tower;

import java.util.ArrayList;
import java.util.List;

import dpozinen.flyable.Flyable;
import dpozinen.io.FWriter;

public class Tower {
	private List<Flyable> observers = new ArrayList<>();
	private List<Flyable> unregistered = new ArrayList<>();

	public void register(Flyable flyable) {
		observers.add(flyable);
		FWriter.write("Tower says: " + flyable + "registered to weather tower.");
	}
	
	public void unregister(Flyable flyable) {
		unregistered.add(flyable);
		FWriter.write("Tower says: " + flyable + " unregistered from weather tower.");
	}

	// notifying observers
	protected void conditionsChanged() {
		for (Flyable f : observers)
			f.updateConditions();
		observers.removeAll(unregistered);
	}
}