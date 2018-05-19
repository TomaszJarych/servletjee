package pl.coderslab.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sess04")
public class Sess04 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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