package solarpanelcalculator;
import java.io.IOException;
import javax.servlet.http.*;

public class DisplayResultServlet extends HttpServlet {
	float systemCost, systemSize, panelAgeEfficiencyLoss, inverterEfficiency, 
	averageDailySunlight, dailyAverageUsage;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("<h2>Your result:</h2>");

		try {
			systemCost = Float.parseFloat(req.getParameter("systemCost"));
			systemSize = Float.parseFloat(req.getParameter("systemSize"));
			panelAgeEfficiencyLoss = Float.parseFloat(req.getParameter("panelAgeEfficiencyLoss"));
			inverterEfficiency = Float.parseFloat(req.getParameter("inverterEfficiency"));
			averageDailySunlight = Float.parseFloat(req.getParameter("averageDailySunlight"));
			dailyAverageUsage = Float.parseFloat(req.getParameter("dailyAverageUsage"));
	    }

	    catch (NumberFormatException ex ) {
	    	resp.getWriter().println("Please enter <b>valid</b> information. Thank you.");
	    	return;
	    }
		
		float sizeConsideringLocation = Calculations.getSizeConsideringLocation(systemSize, 1, 0, 0, 0);
		
		float result = Calculations.getDailyAverageGen(sizeConsideringLocation, panelAgeEfficiencyLoss, inverterEfficiency, averageDailySunlight, 1);
		resp.getWriter().println("In the first year your average daily solar Generation is " + result + " (KWh)");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}
}
