package pl.coderslab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet24")
public class Servlet24 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contexPara = getServletContext().getInitParameter("applicationName");
		resp.getWriter().append("<h1>").append(contexPara).append("</h1>");
	}
}
// #### Zadanie 4
// 1. W projekcie stwórz servlet `Servlet24` dostępny pod adresem
// **/Servlet24**,
// oraz stronę HTML `index.html`, z odnośnikiem do servletu.
// 2. Zainicjuj w deskryptorze parametr dostępny w całej aplikacji o nazwie
// `applicationName` oraz wartości `MyApplicationName`.
// 3. Pobierz parametr `applicationName` w servlecie, a następnie wyświetl na
// stronie.
