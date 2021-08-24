Feller Tamás-Automatizált tesztek a wikipedia.com oldalhoz(SELENIUM-JAVA)

11 teszteset van,amik az oldal különbőző funkcióit teszteli.
	-Bejelentkezés(valid/invalid)
	-Kijelentkezés
	-Adatkezelési nyilatkozat használata
	-Adatok listázása
 	-Több oldalas lista bejárása
 	-Új adat bevitel
 	-Ismételt és sorozatos adatbevitel adatforrásból
 	-Meglévő adat módosítás
 	-Adat vagy adatok törlése
 	-Adatok lementése felületről
 	-Kijelentkezés
Automatizált tesztek futtatásához szükséges, hogy a gépen telepítve legyen:
    - Google Chrome
    - Maven

Futtatás lépései:

    1. Nyissunk egy parancssort.
    2. Navigáljunk a projekt mappába,ahova lementette.
    3. Tesztek futtatása: 'mvn clean test' parancs.
    4. Jelentés készítése: 'mvn allure:serve' parancs.
    5. Jelentés készítése fájlba: 'mvn allure:report' parancs.
    (target/site/allure-maven/index.html)