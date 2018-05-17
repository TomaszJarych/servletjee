package pl.coderslab.cookies;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rememberMe")
public class Cookie7 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		String htmlPage = "<html><body>"
				+ "<form action=\"http://localhost:8080/servletjee/rememberMe\" method=\"POST\"><input type=\"text\" name=\"userName\" id=\"userName\" /><label for=\"userName\"> Wpisz imie</label><label>Zapamietaj mnie <input	type=\"checkbox\"	name=\"remember\"	value=\"checked\"></label></form>"
				+ "</body></html>";
		String result = "";
		if (Objects.isNull(cookies)) {
			result = htmlPage;

		} else {
			Cookie cookieUserName = null;
			for (Cookie cookie : cookies) {
				if ("userName".equals(cookie.getName())) {
					cookieUserName = cookie;
				}
			}
			if (Objects.nonNull(cookieUserName)) {
				result = "<h1>" + "Hello " + cookieUserName.getValue() + " Twoje dane zostaly wczytane z ciasteczka"
						+ "</h1>";
			} else {
				result = result = htmlPage;
			}

		}

		resp.getWriter().append(result);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName").replaceAll(" ", "");
		String remember = req.getParameter("remember");
		String result = "<h1>" + "Hello " + userName + "</h1>";
		if ("checked".equals(remember)) {
			Cookie cookie = new Cookie("userName", userName);
			cookie.setMaxAge(60 * 60 * 24 * 365);
			resp.addCookie(cookie);

		}
		resp.getWriter().append(result);
	}
}
// #### Zadanie 7
// W projekcie stwórz servlet `Cookie7`, dostępny pod adresem `/rememberMe`.
// Następnie:
// 1. W servlecie utwórz formularz, zawierający pole `name` oraz checkbox z
// labelem `Zapamiętaj mnie`.
// Formularz powinien przesyłać dane metodą POST na ten sam adres.
// 2. Dopisz obsługę metody POST w servlecie. Sevlet powinien wyświetlić
// komunikat `Cześć {imię przesłane w formularzu}`.
// W przypadku zaznaczenia checkboxa, imię użytkownika zapamiętaj w ciasteczku.
// 3. Dodaj funkcjonalność, która w przypadku wejścia na stronę metodą GET
// sprawdzi czy istnieje odpowiednie ciasteczko.
// Jeżeli tak to nie wyświetlaj formularza do logowania tylko wyświetl komunikat
// `Cześć {imię przesłane w formularzu}. Twoje dane zostały wczytane z
// ciasteczka`