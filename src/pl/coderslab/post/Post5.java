package pl.coderslab.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Post5")
public class Post5 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String degrees = req.getParameter("degrees");
		String convertionType = req.getParameter("convertionType");
		String output = "";
		try {
			double degreeValue = Double.parseDouble(degrees);
			if (convertionType.equals("celcToFahr")) {
				double result = 32 + ((9 * degreeValue)/5);
				output = degrees +" stopni Celsjusza w skali Fahrenheita to " + result;
			}else {
				double result = (5*(degreeValue - 32))/9;
				output = degrees +" stopni Fahrenheita  w skali Celsjusza to " + result;
			}
			resp.getWriter().append("<h1>").append(output).append("</h1>");
		} catch (NumberFormatException e) {
			resp.getWriter().append("<h1>").append("Zły rodzaj danych").append("</h1>");
		}

	}
}
// #### Zadanie 5
//
// W projekcie stwórz servlet `Post5` oraz stronę HTML `index_4.html`.
// Następnie:
// 1. Do strony dodaj formularz zawierający jedno pole liczbowe oraz dwa
// przyciski `submit`. Każdy z przycisków niech ma inny atrybut `name` mówiący o
// sposobie konwersji.
// 3. Po wysłaniu odpowiednich danych servlet ma przeliczać temperaturę w
// stopniach Celsjusza na temperaturę w stopniach Fahrenheita (i w drugą
// stronę). Który przycisk został kliknięty przez użytkownika dowiesz się po
// wartości pola `convertionType` przesyłanego POST-em.
//
// Skorzystaj z poniższego formularza:
// ```html
// <form action="" method="POST">
// <label>
// Temperatura:
// <input type="number" min="0.00" step="0.01" name="degrees">
// </label>
// <input type="submit" name="convertionType" value="celcToFahr">
// <input type="submit" name="convertionType" value="FahrToCelc">
// </form>
// ```