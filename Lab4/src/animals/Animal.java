package animals;

public abstract class Animal {

    // Pola wymagane w instrukcji
    protected String name;
    protected int legs;

    public Animal(String name, int legs) {
        this.name = name;
        this.legs = legs;
    }

    // Metoda abstrakcyjna do implementacji przez klasy potomne
    public abstract String getDescription();

    // Metoda dodana dla Zadania 5
    public void makeSound() {
        System.out.println(name + " wydaje nieokreślony dźwięk.");
    }

    // Metoda getLegs() jest domyślnie potrzebna,
    // aby klasa Zoo mogła obliczyć sumę nóg [cite: 27]
    // oraz aby działało Zadanie 3 [cite: 38, 39]
    public int getLegs() {
        return legs;
    }

    public String getName() {
        return name;
    }
}