package pl.coderslab.session;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/showAllSession")
public class Sess03_All extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
		String value = req.getParameter("value");
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute(key, value);
		ArrayList<String> keyList = (ArrayList<String>) httpSession.getAttribute("keyList");
		keyList.add(key);
		httpSession.setAttribute("keyList", keyList);
		String htmlStart = "<html><body>";
		String htmlEnd = "</body></html>";
		String table = "<table><tr><th>Klucz</th><th>Wartosc</th></tr>";
		String row ="";
		for (String string : keyList) {
			row += "<tr>"+"<td>"+string+"</td>"+"<td>"+httpSession.getAttribute(string)+"</td>"+"</tr>";
		}

		String output = htmlStart+table+row+"</table>"+htmlEnd;
		resp.getWriter().append(output);
	}
	
}
