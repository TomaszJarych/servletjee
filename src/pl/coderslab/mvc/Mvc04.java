package pl.coderslab.mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Mvc04")
public class Mvc04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/form.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Book> booklist = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			Book book = new Book();
			book.setAuthor(request.getParameter("author"+i));
			book.setTitle(request.getParameter("title"+i));
			book.setIsbn(request.getParameter("isbn"+i));
			booklist.add(book);
		}
		
		request.setAttribute("booklist", booklist);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/result02.jsp").forward(request, response);

	}

}
// #### Zadanie 4
//
// W projekcie stwórz servlet `Mvc04`. Następnie:
// 1. W widoku wyświetlanym metodą `GET` o nazwie `form.jsp` stwórz formularz
// zawierający pola o nazwach (title1, author1, isbn1),
// (title2, author2, isbn2), itd do 5.
// Formularz ma być przesłany metodą POST do servletu `Mvc04`.
// 2. Zaimportuj wcześniej stworzoną klasę `Book`.
// 3. W servlecie `Mvc04` odbierz dane i na ich podstawie stwórz obiekty klasy
// Book.
// 4. Obiekty umieść w liście lub tablicy, którą następnie przekaż do widoku
// `result.jsp`.
// 5. W pętli wyświetl właściwości wszystkich obiektów `title`, `author`.

//<label for="author1">Autor </label>
//<input type="text" name="author1" id="author">
//<label for="title1">Tytul</label>
//<input type="text" name="title1" id="title">
//<label for="isbn1">ISBN</label>
//<input type="text" name="isbn1" id="isbn">