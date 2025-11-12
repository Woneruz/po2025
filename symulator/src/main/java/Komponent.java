public class Komponent {

    // Pola (atrybuty) z diagramu
    // private oznacza, że dostęp do nich jest możliwy tylko wewnątrz tej klasy
    private String nazwa;
    private double waga;
    private double cena;

    // Konstruktor specjalna metoda wywoływana przy tworzeniu obiektu
    // Używamy go aby nadać polom wartości początkowe
    public Komponent(String nazwa, double waga, double cena) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }

    // Metody publiczne (gettery)
    // Pozwalają innym klasom odczytywać wartości prywatnych pól

    public String getNazwa() {
        return nazwa;
    }

    public double getWaga() {
        return waga;
    }


    public double getCena() {
        return cena;
    }
}