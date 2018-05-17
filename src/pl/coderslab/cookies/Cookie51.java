package pl.coderslab.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie51")
public class Cookie51 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("cookie51Check", "visited");
		cookie.setMaxAge(60*60*24*365);
		String result = "<h1>"+"<a href =\"http://localhost:8080/servletjee/Cookie52\">Kliknij tutaj! </a>"+"</h1>";
		resp.addCookie(cookie);
		resp.getWriter().append(result);
	}
}
// #### Zadanie 5
//
// W projekcie stwórz dwa servlety `Cookie51` i `Cookie52`. Następnie:
// 1. Wymagamy aby użytkownik najpierw odwiedził stronę wygenerowaną przez
// servlet `Cookie51`, a dopiero potem mógł przejść do strony wygenerowanej
// przez `Cookie5_2`.
// 2. Gdy użytkownik wejdzie na pierwszą stronę, zapisz odpowiednią informację w
// ciasteczku oraz wygeneruj link do drugiego servletu.
// 3. Przy wejściu na stronę wygenerowaną przez servlet `Cookie52` sprawdź czy
// dane ciasteczko istnieje:
// * Jeżeli istnieje to je usuń oraz wypisz komunikat `Witamy na stronie
// Cookie52`
// * jeżeli ciasteczka nie ma to przekieruj na adres servletu `Cookie51` z
// adnotacją `Nie odwiedziłeś jeszcze tej strony`.
//
// Hint: Przetestuj servlety w różnych przeglądarkach, manualnie usuwając
// ciasteczka (możesz to zrobić w konsoli deweloperskiej)