import org.junit.Test;
import static org.junit.Assert.*;

public class CodingBatTest {

    CodingBat cb = new CodingBat();  // Tworzymy obiekt klasy aby móc wywołać

    @Test
    public void icyHot() {

        // Przypadek 1 z CodingBat
        assertEquals(true, cb.icyHot(120, -1));
        // Przypadek 2 z CodingBat
        assertEquals(true, cb.icyHot(-1, 120));
        // Przypadek 3 z CodingBat
        assertEquals(false, cb.icyHot(2, 120));
        // Dodatkowy przypadek 4
        assertEquals(false, cb.icyHot(-10, -10));
    }

    @Test
    public void backAround() {
        // Przypadek 1 z CodingBat
        assertEquals("tcatt", cb.backAround("cat"));
        // Przypadek 2 z CodingBat
        assertEquals("oHelloo", cb.backAround("Hello"));
        // Przypadek 3 z CodingBat
        assertEquals("aaa", cb.backAround("a"));
    }

    @Test
    public void firstTwo() {
        // Przypadek 1 z CodingBat
        assertEquals("He", cb.firstTwo("Hello"));
        // Przypadek 2 z CodingBat
        assertEquals("ab", cb.firstTwo("abcdefg"));
        // Przypadek 3 przypadek brzegowy - krótszy string
        assertEquals("a", cb.firstTwo("a"));
        // Przypadek 4 przypadek brzegowy - pusty string
        assertEquals("", cb.firstTwo(""));
    }

    @Test
    public void has12() {
        // Przypadek 1 z CodingBat
        assertEquals(true, cb.has12(new int[]{1, 3, 2}));
        // Przypadek 2 z CodingBat
        assertEquals(true, cb.has12(new int[]{3, 1, 4, 5, 2}));
        // Przypadek 3 kiedy 2 jest przed 1
        assertEquals(false, cb.has12(new int[]{2, 1, 3}));
        // Przypadek 4 kiedy nie ma 2
        assertEquals(false, cb.has12(new int[]{1, 1, 1}));
    }
}