package solarpanelcalculator;
import java.io.IOException;
import javax.servlet.http.*;

public class DisplayResultServlet extends HttpServlet {
	SolarPanelSystem system = new SolarPanelSystem();
	public float systemCosts, systemSize, panelAgeEfficiencyLoss, inverterEfficiency, averageDailySunlight, dailyAverageUsage;
	
	public boolean isInvalidValue(float value, float lowerBound, float upperBound) {
		return Calculations.isInvalidValue(value, lowerBound, upperBound);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("<h2>Your result:</h2>");
		
		//Convert inputs to floats.
		try {
			systemCosts = Float.parseFloat(req.getParameter("systemCosts"));
			systemSize = Float.parseFloat(req.getParameter("systemSize"));
			panelAgeEfficiencyLoss = Float.parseFloat(req.getParameter("panelAgeEfficiencyLoss"));
			inverterEfficiency = Float.parseFloat(req.getParameter("inverterEfficiency"));
			averageDailySunlight = Float.parseFloat(req.getParameter("averageDailySunlight"));
			dailyAverageUsage = Float.parseFloat(req.getParameter("dailyAverageUsage"));
	    }
		
		//If input are not valid numbers print this.
	    catch (NumberFormatException ex ) {
	    	resp.getWriter().println("Please enter <b>valid</b> information. Thank you.");
	    	return;
	    }
		
		//Update system instance.
		if (!system.setCosts(systemCosts)) {
			resp.getWriter().println("Please enter costs <b>greater then</b> 0.<br>");
			return;
		}
		if (!system.setSize(systemSize)) {
			resp.getWriter().println("Please enter a size <b>greater then</b> 0.<br>");
			return;
		}
		if (!system.setPanelAgeEfficiencyLoss(panelAgeEfficiencyLoss)) {
			resp.getWriter().println("Please enter a panel age efficiency loss <b>between</b> 0 and 1.<br>");
			return;
		}
		if (!system.setInverterEfficiency(inverterEfficiency)) {
			resp.getWriter().println("Please enter a inverter efficiency <b>between</b> 0 and 1.<br>");
			return;
		}
		
		//Check if rest of information is valid.
		if (isInvalidValue(averageDailySunlight, 0, 24)) {
			resp.getWriter().println("Please enter average daily sunlight hours <b>between</b> 0 and 24.<br>");
			return;
		}
		if (isInvalidValue(dailyAverageUsage, 0, 24)) {
			resp.getWriter().println("Please enter average daily usage hours <b>between</b> 0 and 24.<br>");
			return;
		}
		
		//Right now just to test.
		float north = Calculations.getLocationFactor(1, 0);
		float west = Calculations.getLocationFactor(0, 0);
		
		float sizeConsideringLocation = Calculations.getSizeConsideringLocation(system.getSize(), north, west);
		
		float result = Calculations.getDailyAverageGen(sizeConsideringLocation, system.getPanelAgeEfficiencyLoss(), system.getInverterEfficiency(), averageDailySunlight, 1);
		resp.getWriter().println("In the first year your average daily solar generation is " + result + " (KWh)");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}
}
