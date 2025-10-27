package zadania;

import animals.Animal;
import animals.Dog;
import animals.Parrot;
import animals.Snake;

import java.util.Random;

public class Zoo {

    // Tablica na zwierzęta
    private Animal[] animals = new Animal[100];
    private Random random = new Random();

    // Metoda główna uruchamiająca program
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.fillZooRandomly();
        zoo.printAnimalsInfo();
        zoo.countAllLegs();
    }

    // Metoda do wypełniania tablicy losowymi zwierzętami
    public void fillZooRandomly() {
        System.out.println("Wypełnianie ZOO...");
        for (int i = 0; i < animals.length; i++) {



            int animalType = random.nextInt(3); // Losuje 0, 1, lub 2
            Animal animal;

            switch (animalType) {
                case 0:
                    animal = new Parrot("Papuga " + i);
                    break;
                case 1:
                    animal = new Dog("Pies " + i);
                    break;
                case 2:
                default:
                    animal = new Snake("Wąż " + i);
                    break;
            }
            animals[i] = animal;
        }
        System.out.println("ZOO wypełnione.");
    }

    // Metoda do obliczania sumy nóg
    public void countAllLegs() {
        int totalLegs = 0;
        for (Animal animal : animals) {
            if (animal != null) {
                totalLegs += animal.getLegs();
            }
        }
        System.out.println("---------------------------------");
        System.out.println("ŁĄCZNA LICZBA NÓG W ZOO: " + totalLegs);
    }

    // Metoda do demonstracji i debugowania
    public void printAnimalsInfo() {
        System.out.println("--- Informacje o zwierzętach ---");
        for (Animal animal : animals) {
            if (animal != null) {


                String description = animal.getDescription();
                System.out.println(description);


                animal.makeSound();

                // Kod dla Zadania 3
                int legs = animal.getLegs();

                System.out.println("---");
            }
        }
    }
}