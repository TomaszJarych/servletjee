package pl.coderslab.post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Post4")
public class Post4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random r = new Random();
		String htmlStart = "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
				+ "    <title>Title</title>\n" + "</head>\n" + "<body>";
		String htmlEnd = "</body>\n" + "</html>";
		resp.getWriter().append(htmlStart)
				.append("<form action=\"http://localhost:8080/servletjee/Post4\" method=post>");
		for (int i = 0; i < r.nextInt(6) + 5; i++) {
			resp.getWriter().append("<input name=numbers/><br/>");
		}
		resp.getWriter().append("<input type=submit value=\"Wyslij!\" />\n" + "</form>\n" + "").append(htmlEnd);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> values = req.getParameterMap();
		List<Integer> numbers = new ArrayList<>();
		for (Map.Entry<String, String[]> entry : values.entrySet()) {
			for (String entryValue : entry.getValue()) {
				try {
					numbers.add(Integer.parseInt(entryValue));
				} catch (NumberFormatException e) {
				}
			}

		}
		 Collections.sort(numbers);
		resp.getWriter().append("<h1>").append(numbers.toString()).append("</h1>");
	}
}

// #### Zadanie 4
//
// W projekcie stwórz servlet Post4. Następnie:
// 1. w metodzie doGet, będzie wyświetlał formularz z losową ilością parametrów
// (w zakresie od 5 do 10) o takiej samej nazwie numbers.
// 2. W metodzie doPost pobierz wszystkie parametry - te z nich, które
// reprezentują wartość liczbową, wyświetl posortowane od najmniejszego do
// największego.
//
// Skorzystaj z poniższego formularza:
// html
// <form action= method=post>
// <input name=numbers/><br/>
// <input name=numbers/><br/>
// <input name=numbers/><br/>
// <input name=numbers/><br/>
//
// <!-- parametrów może być więcej -->
//
// <input type=submit value="Wyślij!"/>
// </form>
