package pl.coderslab.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sess02")
public class Sess02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String form = "<form action=\"http://localhost:8080/servletjee/Sess02\" method=\"post\"><input type=\"number\" name=\"note\" id=\"note\"><label for=\"note\">Wpisz ocene</label><input type=\"submit\" value=\"Wyslij\"></form>";
		String htmStart = "<html><body>";
		String htmlEnd = "</body></html>";
		HttpSession httpSession = req.getSession();
		if (httpSession.isNew()) {
			List<Integer> numbers = new ArrayList<>();
			httpSession.setAttribute("notesArray", numbers);
		} 		
		resp.getWriter().append(htmStart).append(form).append(htmlEnd);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String note = req.getParameter("note");
		int noteToAdd = Integer.parseInt(note);
		String notesToPrint = "";
		int sum =0;
		double avearge = 0;
		int counter = 0;
		List<Integer> numbers = (List<Integer>) httpSession.getAttribute("notesArray");
		if (noteToAdd >=1 && noteToAdd <=6) {
			numbers.add(noteToAdd);
		}
		httpSession.setAttribute("notesArray", numbers);
		for (Integer integer : numbers) {
			notesToPrint += integer+" ";
			sum += integer; 
			counter++;
		}
		avearge = sum/counter;
		doGet(req, resp);
		resp.getWriter().append("<h1>").append(numbers.toString()).append(" Średnia to "+avearge).append("</h1>");
		
	
}
}
// #### Zadanie 2 - rozwiązywane z wykładowcą
//
// W projekcie stwórz servlet `Sess02`. Następnie:
// 1. Dodaj do niego formularz z możliwością wpisania oceny.
// 2. Po zatwierdzeniu formularza dodaj ocenę do sesji. Oceny trzymaj w tablicy,
// którą będziesz wkładać do sesji.
// Zadbaj o walidację wprowadzanych ocen (nie mniej niż 1 i nie więcej niż 6).
// 3. Wylicz średnią z ocen (pamiętaj o właśnie dodanej ocenie).
// 4. Wszystkie zapamiętane oceny i ich średnia powinny być wyświetlane pod
// formularzem.