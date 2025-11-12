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
        // Logika obliczania prędkości byłaby skomplikowana (zależna od obrotów, biegu, przełożenia).
        // Więc zwracam z góry ustawioną wartość.
        return aktualnaPredkosc;
    }

    // Zwraca aktualną pozycję samochodu jako String.
    public String getAktPozycja() {
        return this.aktualnaPozycja.getPozycja();
    }

    // Zwraca model samochodu.
    public String getModel() {
        return this.model;
    }

    //

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
        if (!stanWlaczenia) {
            System.out.println("Nie można jechać, silnik wyłączony!");
            return;
        }
        if (this.skrzynia.getAktBieg() == 0) {
            System.out.println("Nie można jechać, wrzuć bieg!");
            return;
        }

//        System.out.println("Jadę do celu...");
//        // Prosta symulacja - teleportuj się do celu xd
//
//        this.aktualnaPozycja = cel;

        aktualnaPozycja.przenies(cel.getX(), cel.getY());
        System.out.println("Dojechałem. Nowa pozycja: " + getAktPozycja());

    }
}