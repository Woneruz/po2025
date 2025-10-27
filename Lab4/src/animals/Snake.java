package animals;

public class Snake extends Animal {

    public Snake(String name) {
        // Ustawiamy 0 nóg
        super(name, 0);
    }

    @Override
    public String getDescription() {
        return "To jest wąż (Snake) o imieniu " + name + ". Ma " + legs + " nóg.";
    }

    @Override
    public void makeSound() {
        // Nadpisanie metody dla Zadania 5
        System.out.println(name + " syczy: 'Ssssss!'");
    }
}