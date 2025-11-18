public class Silnik extends Komponent {

    // Atrybutydla Silnika
    private int maxObroty;
    private int obroty;
    private boolean czyUruchomiony;


    public Silnik(String nazwa, double waga, double cena, int maxObroty) {
        // super wywołuje konstruktor klasy nadrzędnej
        // Musimy to zrobić, by zainicjować pola nazwa, waga, cena
        super(nazwa, waga, cena);

        // Inicjujemy pola specyficzne dla Silnika
        this.maxObroty = maxObroty;
        this.obroty = 0; // Na starcie silnik ma 0 obrotów
        this.czyUruchomiony = false;
    }


    // Uruchamianie
    public void uruchom() {
        if (!czyUruchomiony) {
            this.obroty = 800; // Ustawia obroty na wartość początkową
            this.czyUruchomiony = true;
            System.out.println("Silnik uruchomiony. Obroty biegu jałowego: 800");
        } else {
            System.out.println("Silnik już był uruchomiony.");
        }
    }

    // Zatrzymywanie
    public void zatrzymaj() {
        if (czyUruchomiony) {
            this.obroty = 0; // Zeruje obroty
            this.czyUruchomiony = false;
            System.out.println("Silnik zatrzymany.");
        } else {
            System.out.println("Silnik już był zatrzymany.");
        }
    }

    // Zwiększanie obrotów silnika.
    public void zwiekszObroty() {
        if (czyUruchomiony) {
            if (obroty < maxObroty) {
                this.obroty += 100; // Zwiększamy o 100
            } else {
                this.obroty = maxObroty;
            }
            System.out.println("Obroty: " + this.obroty);
        } else {
            System.out.println("Nie można zwiększyć obrotów - silnik jest wyłączony.");
        }
    }

    // Zmniejszanie obrotów silnika.
    public void zmniejszObroty() {
        if (czyUruchomiony) {
            if (obroty > 800) { // Nie pozwalamy zejść poniżej biegu jałowego
                this.obroty -= 100; // Zmniejszamy o 100
            } else {
                this.obroty = 800;
            }
            System.out.println("Obroty: " + this.obroty);
        } else {
            System.out.println("Nie można zmniejszyć obrotów - silnik jest wyłączony.");
        }
    }

    // Gettery - wsns Metody pozwalające innym klasom

    public int getObroty() {
        return obroty;
    }

    public boolean isCzyUruchomiony() {
        return czyUruchomiony;
    }
}