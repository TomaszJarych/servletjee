package pl.coderslab.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sess01Set")
public class Sess01Set extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		httpSession.setMaxInactiveInterval(60*60*24);
		httpSession.setAttribute("counter", 0);
		
		if (httpSession.isNew()) {
			resp.getWriter().append("<h1>").append("Stworzono sesje").append("</h1>");
		}
	}

}
// #### Zadanie 1 - rozwiązywane z wykładowcą
//
// W projekcie stwórz trzy servlety `Sess01Set`, `Sess01Get`, `Sess03Del`.
// Następnie:
// 1. Pierwszy ma nastawiać informacje w sesji pod kluczem ```counter``` na `0`.
// 2. Drugi ma wyświetlać zawartość sesji pod kluczem ```counter``` i zwiększać
// ją o `1`. Jeżeli nie ma takich danych w sesji, to strona powinna wyświetlić
// odpowiednią informacje.
// 3. Trzeci ma usuwać dane z sesji (tylko te trzymane pod kluczem
// ```counter```).