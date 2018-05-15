package pl.coderslab.get;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get1")
public class Get1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		if (Objects.isNull(start) || Objects.isNull(end)) {
			resp.getWriter().append("<h1>").append("Brak parametrów").append("</h1>");
		} else {
			try {
				for (int i = Integer.parseInt(start); i <= Integer.parseInt(end); i++) {
					resp.getWriter().append("<h1>").append(i + "").append("</h1>");
				}
			} catch (NumberFormatException e) {
				resp.getWriter().append("<h1>").append("Zły rodzaj danych").append("</h1>");
			}

		}

	}

}
// #### Zadanie 1 - rozwiązywane z wykładowcą
//
// 1. W projekcie stwórz servlet `Get1`, który wczyta dwie zmienne: ```start```
// i ```end``` .
// 2. Po uruchomieniu aplikacji na serwerze, w przeglądarce wyświetlą się
// wszystkie liczby od ```start``` do ```end```.
// (dla uproszczenia załóżmy, że będziemy przesyłać tylko liczby całkowite).
// Jeżeli zmienne nie są przesłane, to strona ma wypisać informację 'Brak
// przesłanych zmiennych'.
