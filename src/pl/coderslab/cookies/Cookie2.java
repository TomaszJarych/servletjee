package pl.coderslab.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addToCookie")
public class Cookie2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(60*60*24*365);
		resp.addCookie(cookie);
		
		resp.getWriter().append("<h1>").append("Ciasteczko zostało dodane").append("</h1>");
		
	}
}
// #### Zadanie 2 - rozwiązywane z wykładowcą.
// W projekcie stwórz servlet `Cookie2`, dostępny pod adresem `/addToCookie`,
// oraz plik
// `index2.html`, który wyświetli następujący formularz:
// ```html
// <form action="" method="POST">
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
// Po zatwierdzeniu formularza metodą POST dodajemy nowe ciasteczko o podanej
// nazwie i wartości.
