package pl.coderslab.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Mvc03")
public class Mvc03 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/mvc03.jsp").forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = new Book();
		book.setAuthor(request.getParameter("author"));
		book.setTitle(request.getParameter("title"));
		book.setIsbn(request.getParameter("isbn"));
		
		request.setAttribute("book", book);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/result.jsp").forward(request, response);

		
		
	}
	
}
// #### Zadanie 3
//
// W projekcie stwórz servlet `Mvc03`. Następnie:
// 1. W widoku stwórz formularz zawierający pola o nazwach (title, author,
// isbn). Formularz ma przesłać dane metodą POST do tego samego servletu (do
// metody `doPost`).
// 2. Stwórz Klasę `Book` zawierającą pola zgodne z polami wcześniej utworzonego
// formularza.
// 3. Odbierz dane i na ich podstawie stwórz obiekt klasy Book.
// 4. Przekaż obiekt do widoku `result.jsp`.
// 5. Wyświetl właściwości nowo dodanego obiektu `title`, `author`.
