package pl.coderslab.mvcjdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import pl.coderslab.mvc.Book;

public class BookService {
	private BookDao bookDao;

	public BookService() {
		this.bookDao = new BookDao();
	}

	public String saveBook(Book book) {
		String msg;
		if (bookDao.insertBook(book)) {
			msg = "<h1>Zapisano " + book.toString() + "</h1>";
		} else {
			msg = "<h1>Cannot save entity!</h1>";
		}

		return msg;

	}

	public String deleteBook(Long id) {
		String msg;
		if (bookDao.deleteBook(id)) {
			msg = "<h1>Deleted book with id = " + id + "</h1>";
		} else {
			msg = "<h1>Cannot delete entity with id: " + id + "</h1>";
		}
		return msg;
	}
	
	public String allBooks(){
		String msg="";
		List<Book>bookList = (ArrayList<Book>)bookDao.allBook();
		if (Objects.nonNull(bookDao.allBook())) {
			for (Book book : bookList) {
	
			msg +="<table>\n" + 
					"		<tr>\n" + 
					"		<td>ID</td>\n" + 
					"		<td>Author</td>\n" + 
					"		<td>Title</td>\n" + 
					"		<td>ISBN</td>\n" + 
					"		<td>Akcja</td>\n" + 
					"		</tr>\n" + 
					"		<tr>\n" + 
					"			<td>"+book.getId()+"</td>\n" + 
					"			<td>"+book.getAuthor()+"</td>\n" + 
					"			<td>id</td>\n" + 
					"			<td>id</td>\n" + 
					"			<td>id</td>\n" + 
					"		</tr>\n" + 
					"	</table>";
			}
		} else {

		}
		return msg;
	}

}
