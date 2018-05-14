package pl.coderslab;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet23")
public class Servlet23 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Zadanie3");
		super.init(config);
	}
}
// #### Zadanie 3
//
// 1. W projekcie stwórz servlet `Servlet23`, dostępny pod adresem
// **/Servlet23**,
// który wyświetli w konsoli "Zadanie 3".
// 2. Komunikat na konsoli powinien zostać wyświetlony tylko raz, niezależnie od
// ilości odświeżeń strony. Skorzystaj z metody `init`.
