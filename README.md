

#

#

#

# Dokumentacja Projektu - Baza danych studentów









## Specyfikacja problemu. Przyjęte założenia i ograniczenia.

Program powinien być napisany w języku Java SE (Standard Edition) przy pomocy dowolnego środowiska, w sposób obiektowy wraz z graficznym interfejsem

użytkownika utworzonym z wykorzystaniem biblioteki Swing.

Zadaniem aplikacji jest gromadzenie i przetwarzanie danych o studentach Wydziału Nauk Ścisłych. Spełnia ona funkcje prostej bazy danych.

Program powinien umożliwiać dodanie nowego studenta do bazy, edycje informacji o nim, a także przyłączanie nowych przedmiotów do utworzonego wcześniej wpisu. Ponadto istnieje możliwość sortowania danych oraz przeszukiwania bazy po zadanym kryterium.

Aplikacja składa się z trzech pakietów:

- .model
- .gui (view)
- .controller

W pakiecie model umieściłem klasy dotyczące przechowywania danych oraz logikę biznesową.

Gui zawiera klasy odpowiedzialne za interfejs graficzny wykonany przy użyciu biblioteki Swing.

Controller natomiast przyjmuje dane wejściowe od użytkownika i reaguje na jego interakcje, nakazując aktualizacje modelu oraz odświeżenie widoku.

Umieszczenie plików programu w 3 osobnych pakietach umożliwiło mi rozdzielenie odpowiedzialności za różne funkcje aplikacji.













## Opis algorytmów, zmiennych

### 1. Wczytywanie danych

Dane pobierane są z pliku tekstowego o określonej strukturze, w odpowiedniej kolejności i  interpretowane kolejno:

id, imię, nazwisko, numer albumu, rok w liczbie rzymskiej, liczba przedmiotów na które zapisany jest student, nazwa przedmiotu, ocena, itd.

Przykład rekordu:

| 2;Maciej;Lis;matematyka;3;V;3;Programowanie;NDST;Programowanie;DST;Matma;DB; |
| --- |

Dane te po odczycie są następnie dzielone za pomocą obiektu klasy StringTokenizer tworząc tokeny do średnika „;&quot; .

Każdy token jest parsowany do określonych zmiennych typów prostych. Niektóre z tych typów konwertuje na typy enumeryczne. Wszystkie te zmienne służą do utworzenia instancji typu Student, którą to  po dodaniu do listy stanowi pojedynczy wpis w bazie.

### 2. Zapisywanie danych

 dane zapisywane są do pliku tekstowego o określonej strukturze w sposób odwrotny do odczytu.

Klasa student oraz klasa przedmiot posiada przesłoniętą metodę toString co pozwala zachować przejrzystość kodu, oraz czyni każdą z osobna odpowiedzialną za konwersje do obiektu do tekstu.

### 3. Dodanie studenta

Dodanie studenta odbywa się za pomocą API udostępnionego przez twórców języka do obsługi list.

|   public  void  dodajStudenta(Student student) {                studenci.add(student); } |
| --- |

### 4. Usuwanie Studenta o określonym id

Do usunięcia studenta o określonym id  z listy wykorzystałem wyrażenie lambda które to pozwoliło mi znacząco skrócić zapis, przykład:

|   public  void usunStudenta(  int index) {                studenci.removeIf(s -&gt; s.getId() == index); } |
| --- |

### 5. Typy enumeryczne

W aplikacji wykorzystałem typy enum do utworzenia zmiennych: Kierunek, Ocena, RokStudiów.

Wykoszystnie typów enumerycznych do tego typu problemu pozwoliło mi uniknąć zbędnej walidacji oraz zmniejszyło złożoność problemu jakim jest troska zachowanie poprawności danych.

### 6. Klasa Osoba i klasa Student

Klasa Osoba to klasa abstrakcyjna, po której dziedziczy klasa Student. Klasa ta zawiera pole takie jak: imię, nazwisko. W klasie Student natomiast dochodzą takie pola jak:  id, kierunek, nrAlbumu, rokStudiów oraz przedmioty.

### 7. Klasa Przedmiot oraz ListaPrzedmiotów

Klasa Przedmiot odpowiada za reprezentacje pojedynczego przedmiotu wraz z oceną końcową z tego przedmiotu. Natomiast klasa ListaPrzedmiotów zawiera listę przedmiotów wraz z API do wykonywanie operacjina tej liście.

### 8.  Klasa BazaStudentow

Klasa ta spełnia rolę pojemnika na listę obiektów klasy Student, pozwala nam ona oddzielić bazę studentów od pozostałych klas. Oferuje także API do komunikacji oraz modyfikacji elementów listy.















## Diagram UML

 ![](https://github.com/dmnian/Baza_studentow_java/blob/master/diagram.png)


# Instrukcja użytkownika

## 1. Dodawanie i Usuwanie

W celu dodania nowego studenta należy wypełnić formularz znajdujący się po lewej stronie a następnie zatwierdzić przyciskiem ok. Natomiast, żeby usunąć studenta należy najechać na wiersz i wcisnąć prawy przycisk myszy. Następne z menu kontekstowego należy wybrać usuń rekord.

 ![](https://github.com/dmnian/Baza_studentow_java/blob/master/index.png)

## 2. Wyświetlanie

Po tym jak skończymy dodawać studentów, warto zwinąć formularz wybierając z menu:

okno → Wyświetl → Formularz: Student

 ![](https://github.com/dmnian/Baza_studentow_java/blob/master/index2.png)


## 3.  Dodawanie i usuwanie przedmiotów.

W celu dodania przedmiotu należy wybrać uprzednio dodanego studenta najeżdżając na wiersz i wcisnąć prawy klawisz myszy. Następnie wybieramy: Pokaż przedmioty. Zostaje wyświetlone okno o tytule „Przedmioty&quot; w którym to możemy w prosty sposób dodać kolejne przedmioty wraz z ocenami. Aby usunąć przedmioty wybieramy prawy na odpowiednim wierszu i klikamy usuń.

 ![](https://github.com/dmnian/Baza_studentow_java/blob/master/index3.png)

## 4.  Sortowanie

Aby uporządkować studentów wedle określonego kryterium klikamy na nagłowek kolumny.

 ![](https://github.com/dmnian/Baza_studentow_java/blob/master/index4.png)

## 5. Wyszukiwanie po zadanym kryterium

 ![](https://github.com/dmnian/Baza_studentow_java/blob/master/index5.png)

Żeby wyszukać studentów spełniających okreslone kryterium należy wprowadzić określone kryterium oraz potwierdzić klikając na wyszukaj.



## 6. Odczyt i zapis

Aby zapisac sporządzone przez nas dane należy wybrac Plik→Eksport

Aby odczytać wcześniej przygotowane dane należy wybrać plik import Plik→Import

