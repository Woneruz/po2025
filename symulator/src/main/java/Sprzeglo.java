public class Sprzeglo extends Komponent {

    // true = wciśnięte, false = zwolnione
    private boolean stanSprzegla;


    public Sprzeglo(String nazwa, double waga, double cena) {
        // Wywołanie konstruktora klasy nadrzędnej
        super(nazwa, waga, cena);

        // Domyślnie sprzęgło jest zwolnione (nie wciśnięte)
        this.stanSprzegla = false;
    }


    // wcisnięcie sprzęgła
    public void wcisnij() {
        this.stanSprzegla = true;
        System.out.println("Sprzęgło wciśnięte.");
    }

    // zwolnienie sprzęgła
    public void zwolnij() {
        this.stanSprzegla = false;
        System.out.println("Sprzęgło zwolnione.");
    }


    // status sprzęgła
    public boolean isWcisniete() {
        return stanSprzegla;
    }
}