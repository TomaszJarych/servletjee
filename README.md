<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java EE  - SESJA
### Zadania.

Rozwiązania zadań umieszczaj we wcześniej utworzonym projekcie.

#### Zadanie 1 - rozwiązywane z wykładowcą

W projekcie stwórz trzy servlety `Sess01Set`, `Sess01Get`, `Sess03Del`. Następnie:
1. Pierwszy ma nastawiać informacje w sesji pod kluczem ```counter``` na `0`.
2. Drugi ma wyświetlać zawartość sesji pod kluczem ```counter``` i zwiększać ją o `1`. Jeżeli nie ma takich danych w sesji, to strona powinna wyświetlić odpowiednią informacje.
3. Trzeci ma usuwać dane z sesji (tylko te trzymane pod kluczem ```counter```).

#### Zadanie 2 - rozwiązywane z wykładowcą

W projekcie stwórz servlet `Sess02`. Następnie:
1. Dodaj do niego formularz z możliwością wpisania oceny. 
2. Po zatwierdzeniu formularza dodaj ocenę do sesji. Oceny trzymaj w tablicy, którą będziesz wkładać do sesji.
 Zadbaj o walidację wprowadzanych ocen (nie mniej niż 1 i nie więcej niż 6).
3. Wylicz średnią z ocen (pamiętaj o właśnie dodanej ocenie).
4. Wszystkie zapamiętane oceny i ich średnia powinny być wyświetlane pod formularzem.

-------------------------------------------------------------------------------

#### Zadanie 3.
W projekcie stwórz  `Sess03_Add` dostępny pod adresem `/addToSession` oraz servlet `Sess03_All`
 dostępny pod adresem `/showAllSession`. Następnie:
1. Dodaj do servletu `Sess03_Add` do niego następujący formularz:  
    ```html
    <form action="#" method="POST">
        <label>
            Klucz:
            <input type="text" name="key">
        </label>
        <label>
            Wartość:
            <input type="text" name="value">
        </label>
        <input type="submit">
    
    </form>
    ``` 
2. Dodaj do servletu `Sess03_Add` funkcjonalność, która po zatwierdzeniu formularza metodą POST doda nową zmienną sesyjną o podanej nazwie i wartości. 
3. Dodaj do servletu `Sess03_All` funkcjonalność, która wyświetli w formie tabeli wszystkie dane znajdujące się w sesji (zarówno klucz jak i wartość). 
Do przechowywania kluczy wszystkich wartości w sesji użyj dodatkowej zmiennej sesyjnej, która będzie przechowywać w tablicy lub liście wszystkie klucze.

#### Zadanie 4

W projekcie stwórz servlet `Sess04` oraz stronę HTML `index_04.html`. Następnie:
1. Dodaj do strony formularz, zawierający jedno pole tekstowe (nazwa) oraz dwa pola liczbowe (ilość i cena) służące do dodawania produktu do koszyka. Formularz powinien przekierować do sevletu metodą POST.
2. Po odebraniu danych POST w servelecie dodaj do sesji przedmiot. Pamiętaj, że przedmiotów będzie więcej więc użyj do tego tablicy. 
3. Dodaj do servletu funkcjonalność, która wyświetli zawartość naszego koszyka. Zawartość ma być wyświetlana zarówno w przypadku wejścia metodą GET jak i metodą POST.

Przykładowy koszyk:
```
Produkt 1 - 4 x 5.20zł = 20.80zł
Produkt 2 - 1 x 9.99zł =  9.99zł
Produkt 3 - 1 x 2.20zł =  2.20zł
                   SUMA: 32.99zł
```

#### Zadanie 5

W projekcie stwórz servlet `Sess05`. Następnie:
1. Dodaj do niego formularz z 3 polami tekstowymi (imię, nazwisko, mail) oraz polem numeryczne, do którego będzie wpisywana captcha: wynik działania matematycznego. 
2. Nad polem numerycznym do wpisania zabezpieczenia widnieje informacja: `Wpisz poniżej sumę {liczba1} + {liczba2}`. Liczby powinny być losowe z zakresu od 0 do 100. Servlet powinien obliczyć sumę tych liczb i zapisać wynik do sesji pod kluczem `captcha`
3. Po przesłaniu formularza aplikacja sprawdzi czy wpisany przez użytkownika wynik zgadza się z tym z sesji i wyświetli odpowiedni komunikat.


#### Zadanie 6

W projekcie stwórz servlet `Sess07`. Następnie:
1. Wylosuj w nim 2 liczby całkowite z przedziału 20-1000.
2. Wyświetl 3 pola do wpisania wyników działań na wylosowanych liczbach:
    * dodawania, 
    * odejmowania, 
    * mnożenia.
3. Po wysłaniu formularza wygeneruj stronę, która sprawdzi wpisane przez nas wyniki i przedstawi je w postaci:

```
20	+	3	=	23	Correct
20	-	3	=	17	Correct
20	*	3	=	89	Wrong
```
Hint: w sesji zapamiętaj liczby, a nie wyniki - dzięki temu będziesz trzymać jedną zmienną mniej. 

#### Zadanie 7

W projekcie stwórz servlet `Sess08`. Następnie:
1. Przygotuj sobie tablicę z nazwami krajów sąsiadujących z Polską i ich stolicami.
2. Po uruchomieniu servletu na serwerze, wyświetl formularz z zapytaniem o stolicę sąsiadującego z Polską państwa. W postaci: `Podaj stolicę dla państwa: Niemcy `
3. Po przesłaniu odpowiedzi, system zweryfikuje poprawność odpowiedzi i wyświetl odpowiedni komunikat oraz ponownie wyświetli pytanie o kolejne państwo.
4. Po wyświetleniu wszystkich pytań wyświetli się wynik naszego quizu z informacją o ilości poprawnych odpowiedzi:
`Poprawnych odpowiedzi: 4`.

Hint: To zadanie będzie miało podobny algorytm działania co zadanie 6 - wzoruj się na nim.


