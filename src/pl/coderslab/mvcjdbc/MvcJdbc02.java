package pl.coderslab.mvcjdbc;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-book")
public class MvcJdbc02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookService service;

	public MvcJdbc02() {
		super();
		service = new BookService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg;
		try {
			Long id = Long.parseLong(request.getParameter("id"));
			msg = service.deleteBook(id);
		} catch (Exception ex) {
			msg = "<h1> Please specify GET parameter \"id\"!!!</h1>";
		}
		response.getWriter().append(msg);
	}

}