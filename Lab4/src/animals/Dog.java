package animals;

public class Dog extends Animal {

    public Dog(String name) {
        // Ustawiamy 4 nogi
        super(name, 4);
    }

    @Override
    public String getDescription() {
        return "To jest pies (Dog) o imieniu " + name + ". Ma " + legs + " nogi.";
    }

    @Override
    public void makeSound() {
        // Nadpisanie metody dla Zadania 5
        System.out.println(name + " szczeka: 'Hau hau!'");
    }
}