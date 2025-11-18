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

        // PRZYGOTOWANIE DO SZYBKIEJ JAZDY
        System.out.println("\n--- Przygotowanie do jazdy ---");
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}

        // 1. Wrzucamy wyższy bieg, żeby uzyskać większą prędkość
        mojSamochod.getSprzeglo().wcisnij();
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        mojSamochod.getSkrzynia().zwiekszBieg(); // 1
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        mojSamochod.getSkrzynia().zwiekszBieg(); // 2
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        mojSamochod.getSkrzynia().zwiekszBieg(); // 3
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        mojSamochod.getSkrzynia().zwiekszBieg(); // 4
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        mojSamochod.getSprzeglo().zwolnij();
        try { Thread.sleep(700); } catch (InterruptedException ignored) {}

        // 2. Zwiększamy obroty silnika (bo na niskich obrotach prędkość będzie mała)
        mojSamochod.getSilnik().zwiekszObroty();
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        mojSamochod.getSilnik().zwiekszObroty();
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        mojSamochod.getSilnik().zwiekszObroty(); // Np. do 1100-1200 RPM
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}

        // Sprawdźmy jaką mamy prędkość teoretyczną przed ruszeniem
        System.out.println("Teoretyczna prędkość: " + mojSamochod.getAktPredkosc() + " km/h");
        try { Thread.sleep(700); } catch (InterruptedException ignored) {}


        // JAZDA
        System.out.println("------------------------------");
        System.out.println("-------ZACZYNAMY PODRÓŻ-------");
        System.out.println("------------------------------");

        try { Thread.sleep(800); } catch (InterruptedException ignored) {}
        Pozycja celPodrozy = new Pozycja(100, 50);

        // Teraz metoda jedzDo pobierze prędkość i wykona szybki ruch na mapie
        mojSamochod.jedzDo(celPodrozy);

        // Test wyłączania
        try { Thread.sleep(800); } catch (InterruptedException ignored) {}
        System.out.println("Zmniejszam obroty i wyłączam silnik");

        // Pętla: dopóki obroty są wyższe niż bieg jałowy (800), zmniejszaj je
        while (mojSamochod.getSilnik().getObroty() > 800) {
            mojSamochod.getSilnik().zmniejszObroty();
            try { Thread.sleep(200); } catch (InterruptedException ignored) {}
        }

        // Dopiero gdy obroty spadną do minimum, wyłączamy silnik
        mojSamochod.wylacz();

    }
}