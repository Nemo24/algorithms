package datastructures.array;

/**
 * Created by mm on 5/12/15.
 */
public class StringUnique {
    public static boolean isUniqueChars2(String str) {
        if (str.length() > 256) return false;

        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            System.out.println("stringcharati: "+str.charAt(i));
            System.out.println("int for above: "+val);
            if (char_set[val]) { // Already found this char in string
                return false;
            }
            char_set[val] = true;
        }
            return true;

    }

    public static void main(String[] args) {
        System.out.printf(isUniqueChars2("abcdABCD")+"");
    }
}
