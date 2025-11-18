// Klasa reprezentująca samochód w symulatorze.

public class Samochod {

    // Samochód ma mieć silnik, skrzynię, sprzęgło i pozycję.
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;
    private Sprzeglo sprzeglo;
    private Pozycja aktualnaPozycja;

    // Pozostałe pola
    private boolean stanWlaczenia; // Domyślnie 'false'
    private String nrRejest;
    private String model;
    private double predkoscMax;
    private double aktualnaPredkosc; // Domyślnie 0

    // Stałe używane w obliczeniach prędkości i jazdy samochodu itp
    private static final double PRZELOZENIE_MOSTU = 3.42; // przykładowe przełożenie dyferencjału
    private static final double OBWOD_KOLA_M = 2.04;      // obwód koła w metrach (np. ~2.04 m)


    // Konstruktor klasy Samochod
    public Samochod(Silnik silnik, SkrzyniaBiegow skrzynia, Sprzeglo sprzeglo, Pozycja pozycja,
                    String model, String nrRejest, double predkoscMax) {

        // Przypisanie części do pól samochodu
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.sprzeglo = sprzeglo;
        this.aktualnaPozycja = pozycja;

        // Przypisanie pozostałych właściwości
        this.model = model;
        this.nrRejest = nrRejest;
        this.predkoscMax = predkoscMax;

        // Ustawienie wartości domyślnych
        this.stanWlaczenia = false;
        this.aktualnaPredkosc = 0.0;
    }

    // Włączanie samochodu
    public void wlacz() {
        if (!stanWlaczenia) {
            this.silnik.uruchom();
            this.stanWlaczenia = this.silnik.isCzyUruchomiony();
        } else {
            System.out.println("Samochód jest już włączony.");
        }
    }

    // Wyłączanie samochodu
    public void wylacz() {
        if (stanWlaczenia) {
            this.silnik.zatrzymaj();
            this.skrzynia.setAktualnyBieg(0); // Zerowanie biegu
            this.stanWlaczenia = false;
            System.out.println("Samochód wyłączony.");
        } else {
            System.out.println("Samochód jest już wyłączony.");
        }
    }

    // waga samochodu jako suma wag części
    public double getWaga() {
        // Sumujemy wagi wszystkich części
        double wagaCalkowita = 0.0;
        wagaCalkowita += this.silnik.getWaga();
        wagaCalkowita += this.skrzynia.getWaga();
        wagaCalkowita += this.sprzeglo.getWaga();
        // Można dodać wagę "karoserii" jeśli chcemy
        return wagaCalkowita;
    }

    // Zwraca aktualną prędkość samochodu.
    public double getAktPredkosc() {
        double przelozenieBiegu = this.skrzynia.getAktPrzelozenie();

        if (!stanWlaczenia || przelozenieBiegu <= 0.0) {
            return 0.0;
        }

        double engineRpm = this.silnik.getObroty();
        double wheelRpm = engineRpm / (przelozenieBiegu * PRZELOZENIE_MOSTU);
        double metryNaMinute = wheelRpm * OBWOD_KOLA_M;
        double kmh = (metryNaMinute * 60.0) / 1000.0;
        return Math.min(kmh, predkoscMax);

    }

    // Zwraca aktualną pozycję samochodu jako String.
    public String getAktPozycja() {
        return this.aktualnaPozycja.getPozycja();
    }

    // Zwraca model samochodu.
    public String getModel() {
        return this.model;
    }

    // Gettery komponentów

    public Silnik getSilnik() {
        return silnik;
    }

    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }

    // Metoda symulująca jazdę do określonej pozycji.
    public void jedzDo(Pozycja cel) {
        // Walidacja stanu samochodu
        if (!stanWlaczenia) {
            System.out.println("Nie można jechać, silnik wyłączony!");
            return;
        }
        if (this.skrzynia.getAktBieg() == 0) {
            System.out.println("Nie można jechać, wrzuć bieg!");
            return;
        }

        // 1. Pobieramy fizyczną prędkość (zależną od silnika i skrzyni)
        double predkosc = getAktPredkosc();

        // 2. Sprawdzamy czy mamy moc
        if (predkosc <= 0.0) {
            System.out.println("Samochód stoi (zbyt małe obroty lub bieg jałowy).");
            return;
        }

        // 3. Przekazujemy prędkość do metody przenies
        aktualnaPozycja.przenies(cel.getX(), cel.getY(), predkosc);

        System.out.println("Dojechałem. Nowa pozycja: " + getAktPozycja());
    }
}