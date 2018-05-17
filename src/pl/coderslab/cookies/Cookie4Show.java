package pl.coderslab.cookies;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie4Show")
public class Cookie4Show extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if (Objects.isNull(cookies)) {
			resp.getWriter().append("<h1>").append("Brak ciasteczek").append("</h1>");
		} else {

			for (Cookie cookie : cookies) {
				String result = cookie.getName() + " " + cookie.getValue()+"  ";
				String linkToDelete = "<a href=\"http://localhost:8080/servletjee/Cookie4Del?name="+cookie.getName()+"\">Usuń ciasteczko "+cookie.getName()+"</a>";
				resp.getWriter().append("<h1>").append(result).append(linkToDelete).append("</h1>");
			}
		}
	}

}
// #### Zadanie 4
//
// W projekcie stwórz servlet `Cookie4Show` i `Cookie4Del`. Następnie:
// 1. W servlecie `Cookie4Show` wyświetl wszystkie ciasteczka.
// 2. Przy każdym z nich wygeneruj link do drugiego servletu `Cookie4Del`.
// Pamiętaj o przekazaniu w danych GET nazwy tego ciasteczka.
// 3. W servlecie `Cookie4Del` usuń ciasteczko i poinformuje o tym.
