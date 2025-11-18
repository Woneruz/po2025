// Klasa Pozycja reprezentuje pozycję samochodu na płaszczyźnie 2D (x, y).

public class Pozycja {

    // Atrybuty
    private double x;
    private double y;

    // Pozycja startowa w (0,0)
    public Pozycja() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Ustawianie pozycji startowej
    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Metoda aktualizująca pozycję o podane przesunięcia
    public void aktualizujPozycje(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    // Metoda zwracająca pozycję jako sformatowany String
    public String getPozycja() {
        // String.format by sformatować tekst
        return String.format("(%.1f, %.1f)", this.x, this.y);
    }


    // Przenoszenie do konkretnej pozycji (symulowany ruch samochodu)
    public void przenies(double celX, double celY, double predkoscKmh) {

        double mnoznikSymulacji = 0.5; // Ustalamy jak szybko auto przesuwa się na mapie
        double wielkoscKroku = predkoscKmh * mnoznikSymulacji;

        // Zabezpieczenie dla bardzo małych prędkości
        if (wielkoscKroku < 1.0) {
            wielkoscKroku = 1.0;
        }

        double dx = celX - this.x;
        double dy = celY - this.y;
        double dystans = Math.sqrt(dx * dx + dy * dy);

        if (dystans == 0) return;

        int kroki = (int) (dystans / wielkoscKroku);
        if (kroki == 0) kroki = 1;

        double krokX = dx / kroki;
        double krokY = dy / kroki;

        System.out.println("Rozpoczynam jazdę z prędkością: " + String.format("%.1f", predkoscKmh) + " km/h.");
        System.out.println("Dystans: " + String.format("%.1f", dystans) + " | Ilość kroków symulacji: " + kroki);

        for (int i = 1; i <= kroki; i++) {
            this.x += krokX;
            this.y += krokY;
            System.out.println(" -> krok " + i + "/" + kroki + "  pozycja: " + getPozycja() + " (v=" + String.format("%.1f", predkoscKmh) + "km/h)");
            try { Thread.sleep(400); } catch (InterruptedException ignored) {}
        }

        // Dociągnięcie do celu
        this.x = celX;
        this.y = celY;
        System.out.println("Dotarłem do celu: " + getPozycja());
    }

    // Gettery - Podobno mogą się przydać, jeśli chcemy dostać tylko jedną współrzędną

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}