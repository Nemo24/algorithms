package datastructures.string;

/**
 * Created by mm on 5/3/16.
 */
public class BruteForceStringMatch {
    public static boolean match(String str, String pattern){
        int strLength = str.length();
        int pattLength = pattern.length();
        char[] strArr = str.toCharArray();
        char[] pattArr = pattern.toCharArray();
        for (int i = 0; i < strLength - pattLength +1; i++) {
             int j = 0;
            while (j< pattLength && strArr[i+j] == pattArr[j]){
                j++;
            }
            if (j == pattLength) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "hello";
        String p1 = "hh";
        String p2 = "o";
        String p3 = "h";
        String p4 = "el";
        System.out.println(""+match(s,p1));
        System.out.println(""+match(s,p2));
        System.out.println(""+match(s,p3));
        System.out.println(""+match(s,p4));
    }
}
