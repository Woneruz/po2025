import java.util.ArrayList;
import java.util.Random;

public class Lotto3_1 {  // TO JEST WERSJA Z WYPISYWANIEM CO 100000 LOSOWAŃ (żeby było widać jak działa, ale żeby nie było zbyt dużego spamu w konsoli)
    public static void main(String[] args) {

        Random r = new Random();


        ArrayList<Integer> typy = new ArrayList<>();
        while (typy.size() < 6) {
            int x = r.nextInt(49) + 1;
            if (!typy.contains(x)) {
                typy.add(x);
            }
        }

        System.out.println("Typy: " + typy);


        long start = System.currentTimeMillis();

        long liczbaLosowan = 0;
        ArrayList<Integer> los = new ArrayList<>();


        while (true) {
            los.clear();
            while (los.size() < 6) {
                int x = r.nextInt(49) + 1;
                if (!los.contains(x)) {
                    los.add(x);
                }
            }

            liczbaLosowan++;

            if (liczbaLosowan % 100000 == 0) {
                System.out.println("Losowanie #" + liczbaLosowan + ": " + los);
            }

            if (los.containsAll(typy) && typy.containsAll(los)) {
                break;
            }
        }

        long koniec = System.currentTimeMillis();
        long czas = koniec - start;

        System.out.println("TO JEST WERSJA Z WYPISYWANIEM CO 100000 LOSOWAŃ");
        System.out.println("Wylosowano pełne trafienie po: " + liczbaLosowan + " losowaniach");
        System.out.println("Czas działania programu to: " + czas + " ms");
    }
}
