package datastructures.array;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by mm on 5/12/15.
 */
public class FindIfPermutation {
    public static void printArr(int[] arr){
        for(int i :arr){
            System.out.printf(i + "");
        }
        System.out.println();
    }
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[256]; // Assumption
        char[] s_array = s.toCharArray();
        for (char c : s_array) { // count number of each char in s.
            letters[c]++;
            printArr(letters);
        }

        for (int i = 0; i <t.length(); i++) {
            int c = (int) t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(permutation("hello","elloh")+"");
    }
}
