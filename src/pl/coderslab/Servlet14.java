package pl.coderslab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet14")
public class Servlet14 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> headersNames = new ArrayList<>();
		resp.addHeader("Header1", "value");
		resp.addHeader("Header2", "value2");
		resp.addHeader("Header3", "value3");
		headersNames.addAll(resp.getHeaderNames());
		Map<String, String> headersAndValues = new HashMap<>();
		for (String string : headersNames) {
			headersAndValues.put(string, resp.getHeader(string));
		}
		if (headersNames.isEmpty()) {
			resp.getWriter().append("Brak nagłówków");
		} else {
		for (Map.Entry<String, String> entry : headersAndValues.entrySet()) {
			resp.getWriter().append("<h1>").append(entry.getKey()+" ").append("Wartość :").append(entry.getValue()).append("</h1>");
		}
		}
	}
}