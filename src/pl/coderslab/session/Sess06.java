package pl.coderslab.session;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sess06")
public class Sess06 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random r = new Random();
		int number1 = r.nextInt(980) + 20;
		int number2 = r.nextInt(980) + 20;
		String htmlStart = "<html><body>";
		String htmlEnd = "</body></html>";
		String form = "<form action=\"http://localhost:8080/servletjee/Sess06\" method=\"post\"><div><label for=\"sum\">"
				+ number1 + "+" + number2
				+ "= </label><input type=\"number\" name=\"sum\" id=\"sum\"></div><div><label for=\"subtract\">"
				+ number1 + "-" + number2
				+ "= </label><input type=\"number\" name=\"subtract\" id=\"subtract\"></div><div><label for=\"multiply\">"
				+ number1 + "*" + number2
				+ "= </label><input type=\"number\" name=\"multiply\" id=\"multiply\"></div><input type=\"submit\" value=\"Send\"></form>";
		String output = htmlStart + form + htmlEnd;
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("number1", number1);
		httpSession.setAttribute("number2", number2);
		resp.getWriter().append(output);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String sum = req.getParameter("sum");
		String subtract = req.getParameter("subtract");
		String multiply = req.getParameter("multiply");
		try {
			int sumResult = Integer.parseInt(sum);
			int subtractResult = Integer.parseInt(subtract);
			int multiplyResult = Integer.parseInt(multiply);
			int number1 = (int) httpSession.getAttribute("number1");
			int number2 = (int) httpSession.getAttribute("number2");
			StringBuilder sb = new StringBuilder();
			if (sumResult == number1 + number2) {
				sb.append(number1 + " + ").append(number2 + " = ").append(sumResult + " Correct" + "\n");

			} else {
				sb.append(number1 + " + ").append(number2 + " = ").append(sumResult + " Wrong" + "\n");
			}
			if (subtractResult == number1 - number2) {
				sb.append(number1 + " - ").append(number2 + " = ").append(subtractResult + " Correct" + "\n");

			} else {
				sb.append(number1 + " - ").append(number2 + " = ").append(subtractResult + " Wrong" + "\n");
			}
			if (multiplyResult == number1 * number2) {
				sb.append(number1 + " * ").append(number2 + " = ").append(multiplyResult + " Correct" + "\n");

			} else {
				sb.append(number1 + " * ").append(number2 + " = ").append(multiplyResult + " Wrong" + "\n");
			}

			resp.getWriter().append("<h1>").append(sb).append("</h1>");

		} catch (NumberFormatException e) {
			resp.getWriter().append("<h1>").append("Brak danych").append("</h1>");
		}
	}
}
// #### Zadanie 6
//
// W projekcie stwórz servlet `Sess07`. Następnie:
// 1. Wylosuj w nim 2 liczby całkowite z przedziału 20-1000.
// 2. Wyświetl 3 pola do wpisania wyników działań na wylosowanych liczbach:
// * dodawania,
// * odejmowania,
// * mnożenia.
// 3. Po wysłaniu formularza wygeneruj stronę, która sprawdzi wpisane przez nas
// wyniki i przedstawi je w postaci:
//
// ```
// 20 + 3 = 23 Correct
// 20 - 3 = 17 Correct
// 20 * 3 = 89 Wrong
// ```
// Hint: w sesji zapamiętaj liczby, a nie wyniki - dzięki temu będziesz trzymać
// jedną zmienną mniej.
