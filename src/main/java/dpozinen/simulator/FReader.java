package dpozinen.simulator;

import dpozinen.tower.Tower;

public class FReader {

	private int symCycles;
	
	public void readAndValidate(Tower weatherTower, String fileName) {
		symCycles = 10;
	}
	
	public int getSymCycles() {
		return symCycles;
	}
	
}