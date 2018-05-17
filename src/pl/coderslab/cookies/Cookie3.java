package pl.coderslab.cookies;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie3")
public class Cookie3 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		String time = req.getParameter("Time");
		int timeValue = Integer.parseInt(time);
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(timeValue);
		resp.addCookie(cookie);
		
		resp.getWriter().append("<h1>").append("Dodano ciasteczko").append("</h1>");
	}
}
// #### Zadanie 3
//
// W projekcie stwórz servlet `Cookie3` oraz stronę HTML `index_3.html`, strona
// ma zawierać formularz z polami jak w zadaniu 2, oraz dodatkowym polem
// `select`, z wartościami od 1 - 10.
// Po zatwierdzeniu formularza zostanie dodane ciasteczko o podanej nazwie,
// wartości i czasem życia w godzinach pobranym z pola formularza typu `select`.
//
// Hint: Żeby sprawdzić czy ciasteczko jest poprawnie zapisane przejdź do
// konsoli deweloperskiej Twojej przeglądarki (`ctrl + shift + i`),
// następnie do zakładki `Application` i wybierz Cookies z tabelki po prawej
// stronie. Powinny Ci się wtedy wyświetlić wszystkie ciasteczka jakie są
// trzymane w Twojej przeglądarce.
