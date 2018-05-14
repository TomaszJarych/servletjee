package pl.coderslab;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet21")
public class Servlet21 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		String dateAndTime = localDate + " "+ localTime;
		resp.getWriter().append("<h1>").append(dateAndTime).append("</h2>");

	}

}
// #### Zadanie 1 - rozwiązywane z wykładowcą
//
// 1. W projekcie stwórz servlet `Servlet21` dostępny pod adresem
// **/Servlet21**, który wyświetli w przeglądarce lokalny czas.