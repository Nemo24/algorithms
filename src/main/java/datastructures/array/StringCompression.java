package datastructures.array;

/**
 * Created by mm on 5/12/15.
 */
public class StringCompression {
    public static String compressString(String str) {
        StringBuffer s = new StringBuffer();
        int count = 1;
        s.append(str.charAt(0));
        for (int i =1 ;i< str.length();i++){
            if (str.charAt(i)==str.charAt(i-1)) count++;
            else {
                s.append(count);
                s.append(str.charAt(i));
                count=1;
            }
        }
        s.append(count);
        if (s.length() < str.length())  return s.toString();
        return str;
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));
        System.out.println(compressString("abcdde"));
    }
}
