package pl.coderslab.mvc;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Mvc1" }, initParams = { @WebInitParam(name = "exchangeRate", value = "4.33") })
public class Mvc1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private double exchangeRate;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		exchangeRate = Double.parseDouble(config.getInitParameter("exchangeRate"));
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg;
		try {
			double pln = Double.parseDouble(request.getParameter("euro"))*exchangeRate;
			msg = "W PLN " + pln;
		} catch (Exception e) {
			msg = "Podales zle wartosci" +e.getMessage();
		}
		request.setAttribute("pln", msg);
		getServletContext().getRequestDispatcher("/WEB-INF/mvc/mvc01.jsp").forward(request, response);
	}
}

// }
// #### Zadanie 1 - rozwiązywane z wykładowcą
// Celem zadania jest utworzenie servletu, który wczyta z parametru GET wartość
// podaną w Euro i wyświetli w jsp wartość w złotówkach. W tym celu:
// 1. W projekcie stwórz servlet `Mvc01`, który wczyta zmienną GET :
// ```value```.
// 2. Zdefiniuj parametr inicjalizacji o nazwie `exchangeRate` ze zdefiniowanym
// przelicznikiem walut .
// 3. W kontrolerze (servlecie) przelicz waluty i przekaż do widoku.
// 4. Wyświetl przeliczoną wartość.
