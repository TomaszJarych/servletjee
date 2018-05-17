package pl.coderslab.cookies;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cookie52")
public class Cookie52 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		Cookie c = null;
		String result = "";
		if (Objects.isNull(cookies)) {
			result = "<h1>"
					+ "<a href =\"http://localhost:8080/servletjee/Cookie51\">Nie odwiedziłejs jeszcze strony Cookie51. Kliknij tutaj! </a>"
					+ "</h1>";
		} else {
			for (Cookie cookie : cookies) {
				if ("cookie51Check".equals(cookie.getName()) && "visited".equals(cookie.getValue())) {
					c = cookie;
				}
			}
			if (Objects.isNull(c)) {
				result = "<h1>"
						+ "<a href =\"http://localhost:8080/servletjee/Cookie51\">Nie odwiedziłejs jeszcze strony Cookie51. Kliknij tutaj! </a>"
						+ "</h1>";

			} else {
				c.setMaxAge(0);
				resp.addCookie(c);
				result = "<h1>"+"Witamy na stronie Cookie52"+"</h1>";
			}
		}

		resp.getWriter().append(result);
	}
}
