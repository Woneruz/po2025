import java.util.ArrayList;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> liczby = new ArrayList<>();

        while (liczby.size() < 6) {
            int x = r.nextInt(49) + 1;
            if (!liczby.contains(x)) {
                liczby.add(x);
            }
        }

        System.out.println("Wylosowane liczby: " + liczby);
    }
}
