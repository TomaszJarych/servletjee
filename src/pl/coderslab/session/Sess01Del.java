package pl.coderslab.session;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sess01Del")
public class Sess01Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String result = "";
		if (Objects.nonNull(httpSession.getAttribute("counter"))) {
			httpSession.removeAttribute("counter");
			result = "Usunięto atrybut";
		} else {
			result = "Brak atrybutu";
		}
		resp.getWriter().append("<h1>").append(result).append("</h1>");

	}
}
