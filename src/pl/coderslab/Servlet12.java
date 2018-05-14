package pl.coderslab;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet12")
public class Servlet12 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Komunikat na konsoli");
		response.getWriter().append("<h1>").append("Wynik servletu w przeglądarce").append("</h1>");
	}

}
// #### Zadanie 2 - rozwiązywane z wykładowcą
//
// 1. W projekcie stwórz servlet `Servlet12`, dostępny pod adresem
// **/Servlet12**,
// który wyświetli w przeglądarce "Wynik servletu w przeglądarce".
// 2. Jednocześnie w konsoli wyświetli "Komunikat na konsoli".
// 3. Adres strony powinien być określony za pomocą adnotacji.