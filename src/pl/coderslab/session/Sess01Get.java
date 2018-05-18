package pl.coderslab.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sess01Get")
public class Sess01Get extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String result = "";
		if (httpSession.getAttribute("counter") == null) {
			result = "Atrybut nie istnieje";
		} else {
			int counter = (int) httpSession.getAttribute("counter");
			counter++;
			result = "Atrybut \"counter\" ma wartosc "+counter;
			httpSession.setAttribute("counter", counter);
		}
		resp.getWriter().append("<h1>").append(result).append("</h1>");

	}
}
