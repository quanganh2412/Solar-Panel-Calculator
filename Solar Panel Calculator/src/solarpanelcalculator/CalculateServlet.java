package solarpanelcalculator;
import java.io.IOException;
import javax.servlet.http.*;

public class CalculateServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("html");
		resp.getWriter().println("Display calculations here.");
		resp.getWriter().println("Text: " + req.getParameter("text"));
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}
}
