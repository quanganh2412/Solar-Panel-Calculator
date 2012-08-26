package solarpanelcalculator;

public class Calculations {
	public static boolean isInvalidValue(float value, float lowerBound, float upperBound) {
		return (value < lowerBound || value > upperBound);
	}
	
	public static float getLocationFactor(float percentage, float loss) {
		return percentage * (1 - loss);
	}
	
	public static float getSizeConsideringLocation(float systemSize, float north, float west) {
		return systemSize * (north + west);
	}
	
	public static float getDailyAverageGen(float systemSize, float panelLoss, float inverterEfficiency, float hours, int year) {
		return (systemSize * (1 - (panelLoss * year)) * inverterEfficiency) * hours;
	}
}
