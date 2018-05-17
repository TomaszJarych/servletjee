package pl.coderslab.cookies;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteCookie")
public class Cookie1Del extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();

		try {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("User")) {
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					resp.getWriter().append("<h1>").append("Ciasteczko zostało usunięte").append("</h1>");
				} else {
					resp.getWriter().append("<h1>").append("Nie ma ciasteczka o takiej nazwie").append("</h1>");

				}
			}
		} catch (NullPointerException e) {
			resp.getWriter().append("<h1>").append("Nie ma ciasteczek").append("</h1>");

		}
	}
}
//@Override
//protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	Cookie[] cookies = req.getCookies();
//	Cookie c = null;
//	for (Cookie cookie : cookies) {
//		if ("User".equals(cookie.getName())) {
//			c = cookie;
//		}
//	}
//	String response;
//	if (Objects.isNull(c)) {
//		response = "Brak ciasteczka User";
//	} else {
//		c.setMaxAge(0);
//		resp.addCookie(c);
//		response = "Ciasteczko zostało zjedzone";
//	}
//	resp.getWriter().append("<h1>").append(response).append("</h1>");
//}
//}

