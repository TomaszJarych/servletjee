package pl.coderslab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet13 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Komunikat na konsoli");
		resp.getWriter().append("<h1>Zadanie 3</h1>");
	}

}
//#### Zadanie 3
//
//1. W projekcie stwórz servlet `Servlet13`, dostępny pod adresem **/Servlet13**,
//który wyświetli w przeglądarce "Zadanie 3".
//2. Jednocześnie w konsoli wyświetli "Komunikat na konsoli". 
//3. Adres strony powinien być określony za pomocą odpowiedniego wpisu w deskryptorze wdrożenia.