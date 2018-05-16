package pl.coderslab.get;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get5")
public class Get5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> params = req.getParameterMap();
		StringBuilder sb = new StringBuilder();
		String htmlStart = "<html>\n" + 
				"<head>\n" + 
				"<meta charset=\"UTF-8\">\n" + 
				"<title>Insert title here</title>\n" + 
				"</head>\n" + 
				"<body>";
		String htmlEnd = "</body>\n" + 
				"</html>";

		for (Map.Entry<String, String[]> entry : params.entrySet()) {
			sb.append("<ul>").append("<li>").append(entry.getKey()).append("</li>").append("</ul>");
			for (String value : entry.getValue()) {
				sb.append("<li>" + value + "</li>");

			}
		}
		sb.append("</ul>").append("</ul>");
		resp.getWriter().append(htmlStart).append(sb.toString()).append(htmlEnd);
	}
}
// #### Zadanie 5
// W projekcie stwórz servlet `Get5`, dostępny pod adresem **/Get5**, oraz
// stronę HTML `index.html`, w której umieścisz link do servletu z dodatkowymi
// parametrami
// ``` ?company=coderslab&learn=php&learn=java&learn=ruby&learn=python ```
// po przejściu do servletu wyświetl informacje w następujący sposób:
// ````
// company:
// - coderslab
// learn:
// - php
// - java
// - ruby
// - python
// ````