package solarpanelcalculator;

public class Calculations {

	public static float getSizeConsideringLocation(float systemSize, float nPerc, float wPerc, float nLoss, float wLoss) {
		return systemSize * (nPerc * (1 - nLoss) + wPerc * (1 - wLoss));
	}
	
	public static float getDailyAverageGen(float systemSize, float panelLoss, float inverterEfficiency, float hours, int year) {
		return (systemSize * (1 - (panelLoss * year)) * inverterEfficiency) * hours;
	}
}
