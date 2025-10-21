public class CodingBat {

    // Warmup-1
    public boolean icyHot(int temp1, int temp2) {
        if ((temp1 < 0 && temp2 > 100) || (temp1 > 100 && temp2 < 0)) {
            return true;
        } else {
            return false;
        }
    }

    // Warmup-1
    public String backAround(String str) {
        String last = str.substring(str.length() - 1);
        return last + str + last;
    }

    // String-1
    public String firstTwo(String str) {
        if (str.length() < 2) {
            return str;
        } else {
            return str.substring(0, 2);
        }
    }

    // Array-2
    public boolean has12(int[] nums) {
        boolean foundOne = false;
        for (int num : nums) {
            if (num == 1) {
                foundOne = true;
            }
            if (foundOne && num == 2) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        CodingBat tester = new CodingBat();  // Musimy stworzyć obiekt z klasy aby móc wywołać metody

        // 1. Testy dla metody icyHot
        System.out.println("Test icyHot(120, -1): " + tester.icyHot(120, -1)); // Oczekiwane: true
        System.out.println("Test icyHot(2, 120): " + tester.icyHot(2, 120));   // Oczekiwane: false

        // 2. Testy dla metody backAround
        System.out.println("Test backAround(\"cat\"): " + tester.backAround("cat"));   // Oczekiwane: tcatt
        System.out.println("Test backAround(\"a\"): " + tester.backAround("a"));     // Oczekiwane: aaa

        // 3. Testy dla metody firstTwo
        System.out.println("Test firstTwo(\"Hello\"): " + tester.firstTwo("Hello")); // Oczekiwane: He
        System.out.println("Test firstTwo(\"a\"): " + tester.firstTwo("a"));       // Oczekiwane: a

        // 4. Testy dla metody has12
        int[] testArray1 = {1, 3, 2};
        int[] testArray2 = {3, 1, 4, 5, 2};
        int[] testArray3 = {2, 1, 4}; // 2 jest przed 1

        System.out.println("Test has12({1, 3, 2}): " + tester.has12(testArray1)); // Oczekiwane: true
        System.out.println("Test has12({3, 1, 4, 5, 2}): " + tester.has12(testArray2)); // Oczekiwane: true
        System.out.println("Test has12({2, 1, 4}): " + tester.has12(testArray3)); // Oczekiwane: false
    }

}