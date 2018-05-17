package pl.coderslab.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setCookie")
public class Cookie1Set extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("User", "CodersLab");
		cookie1.setMaxAge(60*60*24);
		resp.addCookie(cookie1);
		resp.getWriter().append("<h1>").append("Stworzono ciasteczko").append("</h1>");
	}
}
// #### Zadanie 1 - rozwiązywane z wykładowcą
//
// W projekcie stwórz trzy servlety `Cookie1Set`, `Cookie1Get`, `Cookie1Del`.
// Następnie:
// 1. Servlet `Cookie1Set ma być dostępny pod adresem `/setCookie`. Ma nastawiać
// ciasteczko o nazwie ```User``` na `Coders Lab`, z ważnością `24h`.
// 2. Servlet `Cookie1Get` ma być dostępny pod adresem `/showCookie`. Ma
// wyświetlać zawartość ciasteczka ```User```. Jeżeli nie ma takiego ciasteczka,
// to powinna się wyświetlić odpowiednia informacje.
// 3. Servlet `Cookie1Del` ma być dostępny pod adresem `/deleteCookie` ma
// kasować ciasteczko o nazwie ```User```. Jeżeli nie ma takiego ciasteczka, to
// powinna się wyświetlić odpowiednia informacje.