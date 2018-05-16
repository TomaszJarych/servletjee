package pl.coderslab.get;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Get62")
public class Get62 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String year = req.getParameter("year");
		StringBuilder sb = new StringBuilder();
		int max = 10;
		int min = -10;
		Random r = new Random();
		for (int i = 0; i <= 5; i++) {
			int mix = r.nextInt(max +1 - min )+min;
			sb.append("<div><h1>").append("<a href =\"http://localhost:8080/servletjee/Get63?year=").append(year).append("&mix=").append(mix).append("\">").append("Link do roku: ").append(year).append(" i mix : "+mix).append("</a>").append("</h1></div>");

		}
		resp.getWriter().append(sb);
		
	}
}
//#### Zadanie 6
//W projekcie stwórz servlety `Get61`, `Get62`, `Get63`,
//dostępne odpowiednio pod adresami **/Get61**, **/Get62**, **/Get63**.
//
//Dopisz następującą funkcjonalność:
//* Pierwszy `Get61`, powinien generować linki do drugiego `Get62` przekazując
//metodą GET dane pod kluczem `year` (od `1980` do `2010`).
//* Drugi `Get62` powinien odebrać przesłane poprzez `GET` dane z pierwszego
//`Get61` i wygenerować `5` linków,
//gdzie każdy z nich ma przenosić do trzeciego `Get63` przekazując metodą GET
//następujące dane:
//* year - dane przesłane z poprzedniej strony
//* mix - losowa wartość z zakresu od `-10` do `10`
//* Trzeci `Get63` ma pobrać dane z `GET` odnośnie roku i wartości `mix` i
//wyświetlić rok zmodyfikowany o tyle lat ile przesłano w `mix`.
//
//Przykład:
//Wynikowy html pierwszego servletu
//```html
//<a href='/Project_02/Get62?year=1980'> Link do roku 1980 </a>
//<a href='/Project_02/Get62?year=1981'> Link do roku 1981 </a>
//...
//<a href='/Project_02/Get62?year=2010'> Link do roku 2010 </a>
//```
//
//Wynikowy html drugiego servletu, któremu przekazaliśmy wartość 1985 generuje
//linki
//(pamiętaj wartości mix są losowe):
//```html
//<a href='/Project_02/Get63?year=1985&mix=-2'> Rok 1985, mix -2 </a>
//<a href='/Project_02/Get63?year=1985&mix=-5'> Rok 1985, mix -5 </a>
//<a href='/Project_02/Get63?year=1985&mix=7'> Rok 1985, mix 7 </a>
//<a href='/Project_02/Get63?year=1985&mix=2'> Rok 1985, mix 2 </a>
//<a href='/Project_02/Get63?year=1985&mix=1'> Rok 1985, mix 1 </a>
//```
//
//Wynikowy html trzeciego servletu - wyświetla odpowiedni rok (tutaj przykład
//dla wartości year = 1985 i mix = -5)
//```html
//Rok to: 1980
//```
//
