package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatusServlet extends HttpServlet {

	public int status = 200;
	public String message = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(200);
		resp.getWriter().write("{\n" +
				"\t\"status\": " + status + ",\n" +
				"\t\"message\": \"" + message + "\"\n" +
				"}");
	}
}
