package dpozinen;

import dpozinen.tower.Simulator;

public class Main {
	public static void main(String []args) {
		Simulator simulator = new Simulator();
		simulator.read(args); // open file; read + validate line; store in tower list; throw invalid input exception
		simulator.run();
	}
}