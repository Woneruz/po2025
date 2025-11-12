public class Main {

    public static void main(String[] args) {

        System.out.println("Tworzenie części ");
        try { Thread.sleep(300); } catch (InterruptedException ignored) {}

        // (nazwa, waga, cena, dodatkowe parametry)
        Pozycja pozycjaStartowa = new Pozycja(0, 0);
        Silnik silnikV8 = new Silnik("V8 Hemi", 150.5, 20000, 7000);
        SkrzyniaBiegow skrzynia6 = new SkrzyniaBiegow("Manualna 6", 40.2, 5000, 6);
        Sprzeglo sprzegloSport = new Sprzeglo("Sportowe", 5.1, 1500);

        System.out.println("Części gotowe");
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        System.out.println("Składanie samochodu ");
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}

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
        try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        System.out.println("Testowanie symulatora");

        // Wywoływanie

        // Test wagi
        try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        System.out.println("Całkowita waga komponentów: " + mojSamochod.getWaga() + " kg");

        // jazda
        try { Thread.sleep(800); } catch (InterruptedException ignored) {}
        System.out.println("------------------------------");
        System.out.println("------------JEDŹMY------------");
        System.out.println("------------------------------");

        // Wyświetl pozycję startową
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        System.out.println("Aktualna pozycja: " + mojSamochod.getAktPozycja());

        // Test włączania
        System.out.println("------------------------------");
        System.out.println("- Przygotowujemy się do jazdy -");
        System.out.println("------------------------------");

        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        mojSamochod.wlacz();

        // Test sprzęgła i biegów
        try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        mojSamochod.getSprzeglo().wcisnij(); // Wciskamy sprzęgło
        try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        mojSamochod.getSkrzynia().zwiekszBieg(); // Wrzucamy 1. bieg
        try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        mojSamochod.getSprzeglo().zwolnij();

        // Test zwiększania obrotów
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        mojSamochod.getSilnik().zwiekszObroty();
        try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        mojSamochod.getSilnik().zwiekszObroty();
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}

        // Test jazdy (metoda jedzDo)
        System.out.println("------------------------------");
        System.out.println("-------ZACZYNAMY PODRÓŻ-------");
        System.out.println("------------------------------");

        try { Thread.sleep(800); } catch (InterruptedException ignored) {}
        Pozycja celPodrozy = new Pozycja(100, 50);
        mojSamochod.jedzDo(celPodrozy);

        // Test wyłączania
        try { Thread.sleep(800); } catch (InterruptedException ignored) {}
        mojSamochod.wylacz();

    }
}