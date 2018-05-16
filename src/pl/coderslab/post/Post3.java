package pl.coderslab.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Post3")
public class Post3 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
		int c = Integer.parseInt(req.getParameter("c"));
		double delta = Math.pow(b, 2) - (4 * a * c);
		if (delta > 0) {
			double x1 = ((b * -1) - Math.sqrt(delta)) / 2 * a;
			double x2 = ((b * -1) + Math.sqrt(delta)) / 2 * a;
			resp.getWriter().append("<h1>").append("Miejsce zerowe funkcji to: ").append("x1 = ")
					.append(x1 + " oraz x2 ").append(x2 + "").append("</h1>");

		}
		else if (delta == 0) {
			double x1 = (b * -1)/2*a;
			resp.getWriter().append("<h1>").append("Miejsce zerowe funkcji to: ").append("x1 = ").append(x1+"").append("</h1>");
		}
		else {
			resp.getWriter().append("<h1>").append("Brak miejsca zerowego ").append("</h1>");
		}

	}

}
// #### Zadanie 3
//
// W projekcie stwórz servlet `Post3` oraz stronę HTML `index_3.html`.
// Następnie:
// 1. Napisz formularz, zawierający trzy pola liczbowe: a, b i c.
// 2. Dopisz funkcjonalność, która po przesłaniu formularza wyliczy miejsca
// zerowe funkcji kwadratowej zdefiniowanej poprzez podane w formularzu liczby
// `(ax^2+bx+c)`. Wyświetl wyliczone miejsca zerowe na stronie.
// W przypadku `delta<0` servlet wyświetli odpowiedni komunikat.
