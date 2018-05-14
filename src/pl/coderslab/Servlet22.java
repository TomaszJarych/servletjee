package pl.coderslab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet22 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myParam = getInitParameter("myParam");
		resp.getWriter().append("<h1>").append(myParam).append("</h1>");
	}

}
//#### Zadanie 2 - rozwiązywane z wykładowcą
//1. W projekcie stwórz servlet `Servlet22` dostępny pod adresem **/Servlet22**,
//oraz stronę HTML `index.html`, z odnośnikiem do servletu.
//2. Zainicjuj w desktyptorze wdrożenia parametr dostępny tylko dla servletu o nazwie `myParam` oraz wartości `coderslab.pl`. 
//3. Pobierz parametr w servlecie, a następnie wyświetl na stronie.
//
