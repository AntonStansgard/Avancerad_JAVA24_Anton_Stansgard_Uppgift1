## Om Projektet

Projektet syfte är att skapa en biluthyrnings applikation, programmet ska vara enkelt att använda samt lättläst för de som vill fortsätta bygga på applikationen.

Exempel:
- **Typ av applikation**: Biluthyrningssystem
- **Huvudfunktioner**: Visa tillgängliga fordon, hyra, returnera,beräkna kostnaden samt avsluta programmet.

---

## Installation

### Krav
- Java 8 eller senare
- IDE som IntelliJ IDEA eller Eclipse

### Steg för att installera
1. Klona repot:
    ```bash
    git clone https://github.com/AntonStansgard/Avancerad_JAVA24_Anton_Stansg-rd_Uppgift1.git
    ```
2. Öppna projektet i din IDE.
3. Kör `Main.java` för att starta programmet.

---

## Arkitektur

Projektet är organiserat enligt följande:

- **Vehicle (abstract class):** Basen för alla fordonsklasser. Innehåller attribut som modell, registreringsnummer och pris per dag, samt metoder för uthyrning och retur.
- **Car, Truck, Suv (klasser):** Arv från `Vehicle`. Varje klass har unika attribut som `horsePower` (Car), `numberOfDoors` (Truck), och `milesRun` (Suv).
- **Rentable (interface):** Definierar metoderna `rentOut()`, `returnRent()` och `calculateBill(int days)`, som implementeras i `Vehicle`.
- **Main:** Huvudprogrammet med en meny för användarinteraktion (t.ex. hyra, returnera och beräkna kostnad).



