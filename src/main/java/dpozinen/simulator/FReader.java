package dpozinen.simulator;

import dpozinen.tower.Tower;

public class FReader {

	private int symCycles;
	
	public void readAndValidate(Tower weatherTower) {
		symCycles = 0;
	}
	
	public int getSymCycles() {
		return symCycles;
	}
	
}