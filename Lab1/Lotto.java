import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    public static void main(String[] args) {
        Random r = new Random();
        Set<Integer> liczby = new HashSet<>();

        while (liczby.size() < 6) {
            liczby.add(r.nextInt(49) + 1);
        }

        System.out.println("Wylosowane Lotto: " + liczby);
    }
}
