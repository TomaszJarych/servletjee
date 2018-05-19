package pl.coderslab.session;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sess04")
public class Sess04 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String result = "";
		
		if (httpSession.isNew()) {
			ArrayList<Sess04Product> productList = new ArrayList<>();
			httpSession.setAttribute("productList", productList);
			result = "Brak produktów na lisce";
		} else {
			double totalSum =0;
			ArrayList<Sess04Product> productList = (ArrayList<Sess04Product>) httpSession.getAttribute("productList");
			for (Sess04Product sess04Product : productList) {
				result += sess04Product.toString()+ "\n";
				totalSum+=sess04Product.getTotalPrice();
			}
			result += "SUMA TO : "+totalSum;
		}
			resp.getWriter().append(result);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String product = req.getParameter("product_name");
		String quantityString = req.getParameter("quantity");
		String priceString = req.getParameter("price");
		if (httpSession.isNew()) {
			ArrayList<Sess04Product> productList = new ArrayList<>();
			httpSession.setAttribute("productList", productList);
		}
		try {
			ArrayList<Sess04Product> productList = (ArrayList<Sess04Product>) httpSession.getAttribute("productList");
			int quantity = Integer.parseInt(quantityString);
			double price = Double.parseDouble(priceString);
			if (quantity > 0 && price > 0) {
				Sess04Product prod = new Sess04Product(product, quantity, price);
				productList.add(prod);
			}
			doGet(req, resp);
		} catch (NullPointerException e) {
			doGet(req, resp);
		}

	}

}
// #### Zadanie 4
//
// W projekcie stwórz servlet `Sess04` oraz stronę HTML `index_04.html`.
// Następnie:
// 1. Dodaj do strony formularz, zawierający jedno pole tekstowe (nazwa) oraz
// dwa pola liczbowe (ilość i cena) służące do dodawania produktu do koszyka.
// Formularz powinien przekierować do sevletu metodą POST.
// 2. Po odebraniu danych POST w servelecie dodaj do sesji przedmiot. Pamiętaj,
// że przedmiotów będzie więcej więc użyj do tego tablicy.
// 3. Dodaj do servletu funkcjonalność, która wyświetli zawartość naszego
// koszyka. Zawartość ma być wyświetlana zarówno w przypadku wejścia metodą GET
// jak i metodą POST.
//
// Przykładowy koszyk:
// ```
// Produkt 1 - 4 x 5.20zł = 20.80zł
// Produkt 2 - 1 x 9.99zł = 9.99zł
// Produkt 3 - 1 x 2.20zł = 2.20zł
// SUMA: 32.99zł
// ```