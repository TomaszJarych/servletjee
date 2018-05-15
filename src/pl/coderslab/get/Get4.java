package pl.coderslab.get;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get4")
public class Get4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userText = req.getParameter("page");
		int page = 0;
		try {
			page = Integer.parseInt(userText);
		} catch (NumberFormatException e) {
			resp.getWriter().append("<h1>").append("Zły rodzaj danych").append("</h1>");
		}
		for (int i = 1; i <= page; i++) {
			if (page % i == 0) {
				resp.getWriter().append("<h1>").append("Dzielniki liczby " + page + " to " + i).append("</h1>");

			}
		}
	}
}
// #### Zadanie 4
//
// 1. W projekcie stwórz servlet `Get4`, dostępny pod adresem **/Get4**,
// oraz stronę HTML `index.html`, w której zawarty jest formularz przesyłany
// metodą GET z jednym polem `page`.
// 2. Po uruchomieniu aplikacji na serwerze, uzupełnieniu i zatwierdzeniu
// formularza w przeglądarce wyświetli się informacja
// czy wartość została przesłana oraz wyświetlone zostaną dzielniki całkowite
// przesłanej liczby.