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

    // Ustawianie pozycji startoee
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


    // Gettery - Podobno mogą się przydać, jeśli chcemy dostać tylko jedną współrzędną

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}