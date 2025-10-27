package animals;

public class Parrot extends Animal {

    public Parrot(String name) {
        // Wywołujemy konstruktor klasy nadrzędnej (Animal)
        // i ustawiamy na sztywno 2 nogi
        super(name, 2);
    }

    @Override
    public String getDescription() {
        // Implementacja metody abstrakcyjnej
        return "To jest papuga (Parrot) o imieniu " + name + ". Ma " + legs + " nogi.";
    }

    @Override
    public void makeSound() {
        // Nadpisanie metody dla Zadania 5
        System.out.println(name + " mówi: 'Kraa! Jestem papugą!'");
    }
}