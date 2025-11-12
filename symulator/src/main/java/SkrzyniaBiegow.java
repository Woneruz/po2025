public class SkrzyniaBiegow extends Komponent {

    // Pola (atrybuty)
    private int aktualnyBieg;
    private int iloscBiegow;
    private double aktualnePrzelozenie; // Z diagramu


    public SkrzyniaBiegow(String nazwa, double waga, double cena, int iloscBiegow) {
        // Wywołanie konstruktora klasy nadrzędnej
        super(nazwa, waga, cena);

        // Inicjujemy pola specyficzne dla Skrzyni Biegów
        this.iloscBiegow = iloscBiegow;
        this.aktualnyBieg = 0; // 0 traktujemy jako bieg jałowy (luz)

        // Od razu ustawiamy przełożenie dla biegu jałowego
        aktualizujPrzelozenie();
    }

    // Metoda do aktualizacji przełożenia na podstawie aktualnego biegu
    private void aktualizujPrzelozenie() {
        switch (this.aktualnyBieg) {
            case 0: // Bieg jałowy (luz)
                this.aktualnePrzelozenie = 0.0;
                break;
            case 1:
                this.aktualnePrzelozenie = 3.615;
                break;
            case 2:
                this.aktualnePrzelozenie = 2.108;
                break;
            case 3:
                this.aktualnePrzelozenie = 1.458;
                break;
            case 4:
                this.aktualnePrzelozenie = 1.0;
                break;
            case 5:
                this.aktualnePrzelozenie = 0.829;
                break;
            case 6:
                this.aktualnePrzelozenie = 0.690;
                break;
            // Można by dodać case -1: dla biegu wstecznego
            default:
                this.aktualnePrzelozenie = 0.0;
        }
        System.out.println("    -> Nowe przełożenie: " + this.aktualnePrzelozenie);
    }


    // Zwiększa aktualny bieg
    public void zwiekszBieg() {
        if (aktualnyBieg < iloscBiegow) {
            aktualnyBieg++;
            System.out.println("Bieg zwiększony na: " + aktualnyBieg);

            // Wywołujemy metodę do zmiany przełożenia
            aktualizujPrzelozenie();
        } else {
            System.out.println("Osiągnięto maksymalny bieg: " + iloscBiegow);
        }
    }

    // Zmniejsza aktualny bieg
    public void zmniejszBieg() {
        if (aktualnyBieg > 0) { // Nie można zejść poniżej biegu jałowego (0)
            aktualnyBieg--;
            System.out.println("Bieg zmniejszony na: " + aktualnyBieg);

            // Wywołujemy metodę do zmiany przełożenia
            aktualizujPrzelozenie();
        } else {
            System.out.println("Jesteś na biegu jałowym (0).");
        }
    }


    // Zwraca aktualny bieg.
    public int getAktBieg() {
        return aktualnyBieg;
    }

    // Zwraca aktualne przełożenie.
    public double getAktPrzelozenie() {
        return aktualnePrzelozenie;
    }

    // Ustawia aktualny bieg (z walidacją)
    public void setAktualnyBieg(int bieg) {
        if (bieg >= 0 && bieg <= iloscBiegow) {
            this.aktualnyBieg = bieg;

            //też wywołujemy metodę
            aktualizujPrzelozenie();
        }
    }
}