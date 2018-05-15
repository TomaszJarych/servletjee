package pl.coderslab.get;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get2")
public class Get2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> parametersMap = req.getParameterMap();
		if (parametersMap.isEmpty()) {
			resp.getWriter().append("<h1>").append("Brak parametrow").append("</h1>");
		} else {
			for (Map.Entry<String, String[]> entry : parametersMap.entrySet()) {
				resp.getWriter().append("<h1>").append(entry.getKey()+" ").append(Arrays.toString(entry.getValue()))
						.append("</h1>");
			}
			// String responseString = ""; INNY SPOSÓB
			// if (entry.getValue().length > 1) {
			// for (int i = 0; i < entry.getValue().length; i++) {
			// responseString += entry.getValue()[i] + " ";
			// }
			// } else {
			// responseString += entry.getKey() + " : " + entry.getValue()[0];
			// }resp.getWriter().append("<h1>").append(responseString).append("</h1>");
			// }
		}
	}
}
// #### Zadanie 2 - rozwiązywane z wykładowcą
//
// 1. W projekcie stwórz servlet `Get2`, który wyświetli listę przesłanych w
// zapytaniu (request) parametrów i ich wartość
// (niezależnie od ilości przesłanych parametrów).