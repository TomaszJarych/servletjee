package pl.coderslab.post;

import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Post2")
public class Post2 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userText = req.getParameter("userText");
		String consequences = req.getParameter("consequences");
		StringTokenizer stringTokenizer = new StringTokenizer(userText);
		if (Objects.isNull(consequences)){
			StringBuilder sb = new StringBuilder();
			while (stringTokenizer.hasMoreTokens()) {
				String token = stringTokenizer.nextToken();
				if (Const.wulgaryzmy.contains(token.toLowerCase())) {
					sb.append(token.replaceAll(".", "*")+" ");
				}
			}
			resp.getWriter().append(sb);
			
		} else {
			resp.getWriter().append("<h1>").append(userText).append("</h1>");

		}
	}
}
//#### Zadanie 2 - rozwiązywane z wykładowcą
//
//W projekcie stwórz servlet `Post2`, oraz stronę HTML `index_2.html`. Następnie:
//1. Dodaj do strony formularz, wysyłany metodą `POST`. Formularz powinien zawierać jedno pole tekstowe i jeden checkbox z opisem `Jestem świadomy konsekwencji`.
//3. Dopisz funkcjonalność, która po przesłaniu formularza sprawdzi, czy wpisany przez użytkownika tekst zawiera wulgaryzmy. Jeżeli tak, to nasz kod powinien zastąpić wulgarne słowo znakami. `****`
//
//Na przykład frazę `cholera, znowu ta JAVA ` powinien zastąpić frazą `*******, znów ta JAVA `.
//Jeżeli użytkownik zaznaczy checkbox `Jestem świadomy konsekwencji`, to program nie sprawdzi wulgaryzmów i wyświetli wpisany tekst.
//Liczba gwiazdek ma odpowiadać liczbie znaków w cenzurowanym słowie.