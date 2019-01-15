package dpozinen.aircraft;

public class Aircraft {
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;
	private long			idCounter;


	Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	private long nextId() {
		return id;
	}
}