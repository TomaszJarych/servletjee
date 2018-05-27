package pl.coderslab.mvcjdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.mvc.Book;

@WebServlet("/add-book")
public class MvcJdbc01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService;

	public MvcJdbc01() {
		super();
		bookService = new BookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("url", "./add-book");
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/mvc03.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Book book = new Book();
		book.setAuthor(request.getParameter("author"));
		book.setTitle(request.getParameter("title"));
		book.setIsbn(request.getParameter("isbn"));
		  
		response.getWriter().append(bookService.saveBook(book));

	}

}
//#### Zadanie 1 - rozwiązywane z wykładowcą
//
//W projekcie stwórz servlet `MvcJdbc01` dostępny pod adresem `/add-book`. Następnie:
//1. W widoku stwórz formularz zawierający pola o nazwach (title, author, isbn)
//Formularz ma przesłać dane metodą POST do tego samego servletu (do metody `doPost`).
//2. Stwórz Klasę `Book` zawierającą pola zgodne z polami wcześniej utworzonego formularza.
//3. Odbierz dane i na ich podstawie stwórz obiekt klasy Book.
//4. Utwórz klasę dostępu do danych korzystającą z bazy danych o nazwie `BookDao`.
//5. Utwórz metodę zapisu do bazy.
//6. Zapisz dane do bazy.