package pl.coderslab.get;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get3")
public class Get3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String width = req.getParameter("width");
		String height = req.getParameter("V");
		if (Objects.isNull(width)) {
			width = "5";
		}
		if (Objects.isNull(height)) {
			height = "10";
		}
		try {
			int width1 = Integer.parseInt(width);
			int height1 = Integer.parseInt(height);
			for (int i = width1; i <= height1; i++) {
				for (int j = 0; j <= height1; j++) {

					resp.getWriter().append("<h1>").append(i + " x " + j + " = " + " " + i * j).append("</h1>");
				}

			}
		} catch (NumberFormatException e) {
			resp.getWriter().append("<h1>").append("Zły rodzaj danych").append("</h1>");
		}
	}

}
// #### Zadanie 3
//
// 1. W projekcie stwórz servlet `Get3`, który ma pobierać dwie zmienne o
// nazwach ```width``` i ```height```.
// Jeżeli informacje nie są przesłane to ```width = 5``` i ```height = 10```.
// 2. Następnie wygeneruj tabliczkę mnożenia o podanej wysokości i szerokości i
// wyświetl ją w przeglądarce.
