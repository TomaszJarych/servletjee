package pl.coderslab.cookies;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/showCookie")
public class Cookie1Get extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if (Objects.isNull(cookies)) {
			resp.getWriter().append("<h1>").append("Nie ma ciasteczek").append("</h1>");
		} else {
			for (Cookie cookie : cookies) {
				resp.getWriter().append("<h1>").append(cookie.getName()+" ").append(cookie.getValue()).append("</h1>");
			}

		}
	}
}
//public final class Cookie1Get extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Cookie[] cookies = req.getCookies();
//		Cookie c = null;
//		for (Cookie cookie : cookies) {
//			if ("User".equals(cookie.getName())) {
//				c = cookie;
//			}
//		}
//		String response;
//		if (Objects.isNull(c)) {
//			response = "Brak ciasteczka User";
//		}else {
//			response = c.getValue();
//		}
//		resp.getWriter().append("<h1>").append(response).append("</h1>");
//	}
//
//}
