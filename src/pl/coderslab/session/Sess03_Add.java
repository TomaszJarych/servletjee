package pl.coderslab.session;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addToSession")
public class Sess03_Add extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String form = "<form action=\"http://localhost:8080/servletjee/showAllSession\" method=\"POST\"><label>Klucz: <input type=\"text\" name=\"key\"></label><label>Wartosc: <input type=\"text\" name=\"value\"></label> <input type=\"submit\"></form>";
		String htmlStart = "<html><body>";
		String htmlEnd = "</body></html>";
		String output = htmlStart + form + htmlEnd;
		HttpSession httpSession = req.getSession();
		if (httpSession.isNew()) {
			ArrayList<String> keyList = new ArrayList<>();
			httpSession.setAttribute("keyList", keyList);
		}
		resp.getWriter().append("<h1>").append(output).append("</h1>");
	}

}
// #### Zadanie 3.
// W projekcie stwórz `Sess03_Add` dostępny pod adresem `/addToSession` oraz
// servlet `Sess03_All`
// dostępny pod adresem `/showAllSession`. Następnie:
// 1. Dodaj do servletu `Sess03_Add` do niego następujący formularz:
// ```html
// <form action="#" method="POST">
// <label>
// Klucz:
// <input type="text" name="key">
// </label>
// <label>
// Wartość:
// <input type="text" name="value">
// </label>
// <input type="submit">
//
// </form>
// ```
// 2. Dodaj do servletu `Sess03_Add` funkcjonalność, która po zatwierdzeniu
// formularza metodą POST doda nową zmienną sesyjną o podanej nazwie i wartości.
// 3. Dodaj do servletu `Sess03_All` funkcjonalność, która wyświetli w formie
// tabeli wszystkie dane znajdujące się w sesji (zarówno klucz jak i wartość).
// Do przechowywania kluczy wszystkich wartości w sesji użyj dodatkowej zmiennej
// sesyjnej, która będzie przechowywać w tablicy lub liście wszystkie klucze.
