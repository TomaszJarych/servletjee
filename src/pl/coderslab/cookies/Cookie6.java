package pl.coderslab.cookies;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie6")
public class Cookie6 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		String result = "";
		if (Objects.isNull(cookies)) {
			 result = "<h1>" + "<a href =\"http://localhost:8080/servletjee/index_7.html\">Kliknij tutaj! </a>"
					+ "</h1>";

		} else {
			String textColors = "";
			String backgroundColor = "";
			for (Cookie cookie : cookies) {
				if ("textColors".equals(cookie.getName())) {
					textColors = cookie.getValue();

				}
				if ("backgroundColor".equals(cookie.getName())) {
					backgroundColor = cookie.getValue();
				}

			}
			result = "Zapamiętany w ciasteczku kolor tekstu to: "+textColors+" oraz tła jako: " +backgroundColor+" Twój wybór został zapisane w ciasteczku ";
		}
		resp.getWriter().append("<h1>").append(result).append("</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String textColors = req.getParameter("textColors");
		String backgroundColor = req.getParameter("backgroundColor");
		String result = "Wybrałeś kolor tektsu : " + textColors + " oraz tła jako " + backgroundColor;
		Cookie cookieText = new Cookie("textColors", textColors);
		cookieText.setMaxAge(60 * 60 * 24 * 365);
		Cookie cookieBackground = new Cookie("backgroundColor", backgroundColor);
		resp.addCookie(cookieText);
		resp.addCookie(cookieBackground);
		resp.getWriter().append("<h1>").append(result).append("</h1>");

	}
}
// #### Zadanie 6
// W projekcie stwórz servlet `Cookie6`, oraz stronę HTML `index_7.html`.
// Następnie:
// 1. Do strony dodaj formularz umożliwiający wybór koloru tekstu i tła
// wyświetlanego na odwiedzanym servlecie.
// 2. Po przesłaniu kolorów metodą POST użytkownik zostanie przekierowany do
// servletu, który zapamięta wybrane kolory w ciasteczkach. Servlet powinien
// również wyświetlić prosty tekst w wybranym kolorze na wybranym tle:
// ````
// Wybrałeś kolor tekstu jako: <wybrany_kolor_1>, oraz tła jako:
// <wybrany_kolor_2>. Twój wybór został zapisane w ciasteczku.
// ````
// 3. Do servletu dodaj funkcjonalność która sprawdzi czy istnieją odpowiednie
// ciasteczka. Jeżeli istnieją to servlet powinien wyświetlić tekst:
// ````
// Zapamiętany w ciasteczku kolor tekstu to: <wybrany_kolor_1>, oraz tła jako:
// <wybrany_kolor_2>.
// ````
// Ta funkcjonalność powinna działać **tylko** w przypadku kiedy dane POST nie
// zostały wysłane.
// 4. Do servletu dopisz kod sprawdzający czy kolory zostały wybrane przez
// użytkownika (czyli przesłane POST-em) lub istnieją w ciasteczku. Jeżeli
// kolory nie zostały wybrane i nie ma odpowiedniego ciasteczka to przekieruj
// użytkownika do strony wyboru.
