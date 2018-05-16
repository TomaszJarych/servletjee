package pl.coderslab.get;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Get63")
public class Get63 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String year = req.getParameter("year");
		String mix = req.getParameter("mix");
		try {
			resp.getWriter().append("<h1>").append("Rok wynikowy to ").append(Integer.parseInt(year)+Integer.parseInt(mix)+"" ).append("</h1>");
			
		} catch (NumberFormatException e) {
			resp.getWriter().append("Błąd danych");
		}
	}

}
