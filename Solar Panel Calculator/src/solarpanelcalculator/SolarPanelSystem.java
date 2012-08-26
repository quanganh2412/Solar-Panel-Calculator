package solarpanelcalculator;

public class SolarPanelSystem {
	private float costs, size, panelAgeEfficiencyLoss, inverterEfficiency;
	
	public boolean isInvalidValue(float value, float lowerBound, float upperBound) {
		return Calculations.isInvalidValue(value, lowerBound, upperBound);
	}
	
	float getCosts() {
		return costs;
	}
	boolean setCosts(float value) {
		if (value < 0) {
			return false;
		}
		costs = value;
		return true;
	}
	
	float getSize() {
		return size;
	}
	boolean setSize(float value) {
		if (value < 0) {
			return false;
		}
		size = value;
		return true;
	}
	
	float getPanelAgeEfficiencyLoss() {
		return panelAgeEfficiencyLoss;
	}
	boolean setPanelAgeEfficiencyLoss(float value) {
		if (isInvalidValue(value, 0, 1)) {
			return false;
		}
		panelAgeEfficiencyLoss = value;
		return true;
	}
	
	float getInverterEfficiency() {
		return inverterEfficiency;
	}
	boolean setInverterEfficiency(float value) {
		if (isInvalidValue(value, 0, 1)) {
			return false;
		}
		inverterEfficiency = value;
		return true;
	}
}