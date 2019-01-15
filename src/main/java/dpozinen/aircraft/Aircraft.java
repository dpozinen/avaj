package dpozinen.aircraft;

public class Aircraft {
	protected long			id;
	protected String		name;
	protected Coordinates	coordinates;
	static private long		idCounter = 1;


	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		id = nextId();
	}

	private long nextId() {
		return idCounter++;
	}

	@Override
	public String toString() {
		return "#" + name + "(" + id + ")";
	}

	void checkBounds() {
		if (coordinates.getHeight() > 100)
			coordinates.setHeight(100);
		if (coordinates.getHeight() < 0)
			coordinates.setHeight(0);
	}

	protected int weatherToInt(String s) {
		if (s.equals("SUN"))
			return 0;
		if (s.equals("RAIN"))
			return 1;
		if (s.equals("FOG"))
			return 2;
		else
			return 3;
	}
}