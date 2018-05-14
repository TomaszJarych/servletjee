package pl.coderslab;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet25")
public class Servlet25 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String browser = req.getHeader("user-agent");
		String ipAddress = req.getHeader("Host");
		LocalDateTime date = LocalDateTime.now();
		resp.getWriter().append("<h1>").append(ipAddress).append("</h1>");
		resp.getWriter().append("<h1>").append(browser).append("</h1>");
		resp.getWriter().append("<h1>").append(date+"").append("</h1>");
	}
}

// #### Zadanie 5
// 1. W projekcie stwórz servlet `Servlet25` dostępny pod adresem
// **/Servlet25**,
// 2. Wyświetl w przeglądarce poniższe informacje:
// * Adres IP
// * Przeglądarkę
// * Aktualny czas
