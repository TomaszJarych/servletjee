package pl.coderslab.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Mvc2")
public class Mvc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = "";
		try {
			int start = Integer.parseInt(request.getParameter("start"))+10;
			int end = Integer.parseInt(request.getParameter("end"))+10; 
			for (int i = start; i < end; i++) {
				msg +=  i+" ";
			}	
		} catch (NumberFormatException e) {
			msg = "Podales zle wartosic"+ e.getMessage();
		} 
		request.setAttribute("output", msg);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/mvc02.jsp").forward(request, response);
		
//		request.setAttribute("start", Integer.parseInt(request.getParameter("start"))+10);
//		request.setAttribute("end", Integer.parseInt(request.getParameter("end"))+10);
		// pętla do wyświetlania w mvc02.jsp
	}
	

}
// #### Zadanie 2 - rozwiązywane z wykładowcą
//
// W projekcie stwórz servlet `Mvc02`, który wczyta dwie zmienne GET :
// ```start``` i ```end``` . Następnie:
// 1. W servlecie zwiększ obie wartości o wartość `10`, przekaż zwiększone
// zmienne do widoku JSP .
// 2. W widoku wyświetl wszystkie liczby ```start``` do ```end```.
