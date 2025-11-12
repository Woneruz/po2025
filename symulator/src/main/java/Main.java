public class Main {

    public static void main(String[] args) {

        System.out.println("--- Tworzenie części ---");

        // (nazwa, waga, cena, dodatkowe parametry)
        Pozycja pozycjaStartowa = new Pozycja(0, 0);
        Silnik silnikV8 = new Silnik("V8 Hemi", 150.5, 20000, 7000);
        SkrzyniaBiegow skrzynia6 = new SkrzyniaBiegow("Manualna 6", 40.2, 5000, 6);
        Sprzeglo sprzegloSport = new Sprzeglo("Sportowe", 5.1, 1500);

        System.out.println("Części gotowe!");
        System.out.println("--- Składanie samochodu ---");

        // Składanie obiektu samochód używając konstruktora
        Samochod mojSamochod = new Samochod(
                silnikV8,
                skrzynia6,
                sprzegloSport,
                pozycjaStartowa,
                "Dodge Challenger",
                "KR 12345",
                250.0
        );

        System.out.println("Samochód złożony: " + mojSamochod.getModel());
        System.out.println("Testowanie symulatora");

        // Wywoływanie metod

        // Wyświetl pozycję startową
        System.out.println("Aktualna pozycja: " + mojSamochod.getAktPozycja());

        // Test włączania
        mojSamochod.wlacz();

        // Test sprzęgła i biegów
        mojSamochod.getSprzeglo().wcisnij(); // Wciskamy sprzęgło (musimy dodać getter w Samochod)
        mojSamochod.getSkrzynia().zwiekszBieg(); // Wrzucamy 1. bieg (też przydałby się getter)
        mojSamochod.getSprzeglo().zwolnij();

        // Test zwiększania obrotów
        mojSamochod.getSilnik().zwiekszObroty();
        mojSamochod.getSilnik().zwiekszObroty();

        // Test jazdy (metoda jedzDo)
        Pozycja celPodrozy = new Pozycja(100, 50);
        mojSamochod.jedzDo(celPodrozy);

        // Test wyłączania
        mojSamochod.wylacz();

        // Test wagi
        System.out.println("Całkowita waga komponentów: " + mojSamochod.getWaga() + " kg");
    }
}