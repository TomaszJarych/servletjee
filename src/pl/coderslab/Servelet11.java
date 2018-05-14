package pl.coderslab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet11")
public class Servelet11 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("<h1>").append("Hello FirstServlet").append("</h1>");
	}

}
// #### Zadanie 1 - rozwiązywane z wykładowcą
//
// 1. Stwórz projekt a w nim servlet `Servlet11`, dostępny pod adresem
// **/Servlet11**,
// który wyświetli na konsoli "Hello First Servlet".
//
// 3. Skonfiguruj Eclipse wraz z serwerem Tomcat.
// 4. Uruchom projekt.