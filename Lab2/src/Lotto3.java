import java.util.ArrayList;
import java.util.Random;

public class Lotto3 {
    public static void main(String[] args) {

        ArrayList<Integer> typy = new ArrayList<>();
        for (String arg : args) {
            typy.add(Integer.parseInt(arg));  // zamiana tekstu na liczbę
        }

        Random r = new Random();
        ArrayList<Integer> liczby = new ArrayList<>();

        while (liczby.size() < 6) {
            int x = r.nextInt(49) + 1;
            if (!liczby.contains(x)) {
                liczby.add(x);
            }
        }


        int trafienia = 0;
        for (int liczba : typy) {
            if (liczby.contains(liczba)) {
                trafienia++;
            }
        }

        System.out.println("Twoje typy: " + typy);
        System.out.println("Wylosowane liczby: " + liczby);
        System.out.println("Liczba trafień: " + trafienia);
    }
}
