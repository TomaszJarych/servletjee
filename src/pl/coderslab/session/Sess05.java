package pl.coderslab.session;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sess05")
public class Sess05 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random r = new Random();
		int number1 = r.nextInt(100);
		int number2 = r.nextInt(100);
		int result = number1 + number2;
		String htmlStart = "<html><body>";
		String htmlEnd = "</body></html>";
		String form = "<form action=\"http://localhost:8080/servletjee/Sess05\" method=\"post\"><input type=\"text\" name=\"name\" id=\"name\"><label for=\"name\">Wpisz imie </label><input type=\"text\" name=\"surname\" id=\"surname\"><label for=\"surname\">Wpisz nazwisko </label><input type=\"email\" name=\"email\" id=\"email\"><label for=\"email\">Wpisz email</label><div><input type=\"number\" name=\"captcha\" id=\"captcha\">"
				+ "<label for=\"captcha\">Wpisz captcha " + number1 + " + " + number2
				+ "</label></div><input type=\"submit\" value=\"Send\"></form>";
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("captcha", result);
		resp.getWriter().append(htmlStart).append(form).append(htmlEnd);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String captcha = req.getParameter("captcha");
		HttpSession httpSession = req.getSession();
		int captchaParameter = Integer.parseInt(captcha);
		int captchaResult = (int) httpSession.getAttribute("captcha");
		String result = "Bledne dane";
		if (captchaResult == captchaParameter) {
			result = "Brawo " + name + " " + surname + " podales prawidlowy wynik";

		}
		resp.getWriter().append("<h1>").append(result).append("</h1>");
	}

}
// #### Zadanie 5
//
// W projekcie stwórz servlet `Sess05`. Następnie:
// 1. Dodaj do niego formularz z 3 polami tekstowymi (imię, nazwisko, mail) oraz
// polem numeryczne, do którego będzie wpisywana captcha: wynik działania
// matematycznego.
// 2. Nad polem numerycznym do wpisania zabezpieczenia widnieje informacja:
// `Wpisz poniżej sumę {liczba1} + {liczba2}`. Liczby powinny być losowe z
// zakresu od 0 do 100. Servlet powinien obliczyć sumę tych liczb i zapisać
// wynik do sesji pod kluczem `captcha`
// 3. Po przesłaniu formularza aplikacja sprawdzi czy wpisany przez użytkownika
// wynik zgadza się z tym z sesji i wyświetli odpowiedni komunikat.
