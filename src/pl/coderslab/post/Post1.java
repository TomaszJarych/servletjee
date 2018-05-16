package pl.coderslab.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Post1")
public class Post1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userInput = req.getParameter("userInput");
		String userInput2 = req.getParameter("userInput2");
		resp.getWriter().append("<h1>").append("Witaj "+userInput).append(" "+userInput2).append("</h1>");
	}
}
// #### Zadanie 1 - rozwiązywane z wykładowcą
//
// W projekcie stwórz servlet `Post1` oraz stronę HTML `index_1.html`, w której
// zawarty jest formularz przesyłający imię i nazwisko. Po uruchomieniu na
// serwerze i uzupełnieniu formularza w przeglądarce wyświetli się napis:
// `Witaj, <podane imię> <podane nazwisko>`.
