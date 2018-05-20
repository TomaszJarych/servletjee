package pl.coderslab.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sess07")
public class Sess07 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		int counter = 0;
		if (httpSession.isNew()) {
			httpSession.setAttribute("result", 0);
			httpSession.setAttribute("counter", counter);
		} else {
			counter = (int) httpSession.getAttribute("counter") + 1;
			httpSession.setAttribute("counter", counter);
		}
		String[][] countryList = { { "Niemcy", "Berlin" }, { "Czechy", "Praga" }, { "Słowacja", "Bratysława" },
				{ "Ukraina", "Kijów" }, { "Białoruś", "Mińsk" }, { "Litwa", "Wilno" }, { "Rosja", "Moskwa" } };
		String output = "";
		if (counter < countryList.length) {
			String country = countryList[counter][0];
			String capital = countryList[counter][1];
			String htmlStart = "<html><head><meta charset=\"utf-8\" /></head><body>";
			String htmlEnd = "</body></html>";
			String form = "<form action=\"http://localhost:8080/servletjee/Sess07\" method=\"post\"><div><label for=\"text\">Podaj stolice dla "
					+ country + " </label><input type=\"text\" name=\"text\" id=\"text\"><input type=\"submit\" value=\"Send\"></div></form>";
			httpSession.setAttribute("capital", capital);
			output = htmlStart + form + htmlEnd;
		} else {
			int result = (int) httpSession.getAttribute("result");
			output = "Twoj wynik to " + result;
		}
		resp.getWriter().append("<h1>").append(output).append("</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String htmlStart = "<html><head><meta charset=\"utf-8\" /></head><body>";
		String htmlEnd = "</body></html>";
		HttpSession httpSession = req.getSession();
		String capital = (String) httpSession.getAttribute("capital");
		int result = (int) httpSession.getAttribute("result");
		String userInput = req.getParameter("text");
		String output = "";
		if (userInput.equals(capital)) {
			result++;
			httpSession.setAttribute("result", result);
			output = "Brawo, prawidlowa odpowiedz";

		} else {
			output = "Bledna odpowiedz";
		}
		resp.getWriter().append(htmlStart).append("<h1>").append(output).append("</h1>").append(" ").append(htmlEnd);
		doGet(req, resp);
	}
}
// #### Zadanie 7
//
// W projekcie stwórz servlet `Sess08`. Następnie:
// 1. Przygotuj sobie tablicę z nazwami krajów sąsiadujących z Polską i ich
// stolicami.
// 2. Po uruchomieniu servletu na serwerze, wyświetl formularz z zapytaniem o
// stolicę sąsiadującego z Polską państwa. W postaci: `Podaj stolicę dla
// państwa: Niemcy `
// 3. Po przesłaniu odpowiedzi, system zweryfikuje poprawność odpowiedzi i
// wyświetl odpowiedni komunikat oraz ponownie wyświetli pytanie o kolejne
// państwo.
// 4. Po wyświetleniu wszystkich pytań wyświetli się wynik naszego quizu z
// informacją o ilości poprawnych odpowiedzi:
// `Poprawnych odpowiedzi: 4`.