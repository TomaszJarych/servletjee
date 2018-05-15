package pl.coderslab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet26")
public class Servlet26 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String browser = req.getHeader("user-agent");
		String text = "Użytkownik używa przeglądarki: ";
		if (browser.contains("Chrome")) {
			resp.getWriter().append("<h1>").append(text).append("Google Chrome").append("</h1>");
		}else if (browser.contains("Firefox")) {
			resp.getWriter().append("<h1>").append(text).append("Mozilla Firefox").append("</h1>");
			
		}else if (browser.contains("Opera")) {
			resp.getWriter().append("<h1>").append(text).append("Opera").append("</h1>");
			
		}else if (browser.contains("Safari")) {
			resp.getWriter().append("<h1>").append(text).append("Safari").append("</h1>");
			
		}else {
			resp.getWriter().append("<h1>").append("Przeglądarka niezidentyfikowana").append("</h1>");

		}
		
	}
}
// #### Zadanie 6
//
// 1. W projekcie stwórz servlet `Servlet26` dostępny pod adresem
// **/Servlet26**,
// 2. Pobierz z nagłówka HTTP informacje na temat przeglądarki użytkownika, a
// następnie wyświetl na stronie informacje w postaci:
// `Użytkownik używa przeglądarki: Chrome`.
//
// Hint: Sprawdź jakiej przeglądarki używa użytkownik wg. poniższych zasad
// (jeśli ciąg zawiera):
// * `Chrome` - `Google Chrome`
// * `Firefox` - `Mozilla Firefox`
// * `Opera` - `Opera`
// * `Safari` - `Safari`
//
// Jeśli posiadasz kilka przeglądarek, sprawdź czy Twój kod działa prawidłowo.
