import java.util.HashMap;
import java.util.Map;

public class Scratch {
    public static int findLength(String str) {
      int windowStart = 0;
      int maxLength = 0;
      Map<Character,Integer> charMap = new HashMap();
      for (int windowEnd = 0;windowEnd< str.length();windowEnd++) {
        char currentChar = str.charAt(windowEnd);
        if (charMap.containsKey(currentChar)) {
          int index = charMap.get(currentChar);
          charMap.remove(currentChar);
          windowStart = Math.max(windowStart, index + 1);
        }
        charMap.put(currentChar,windowEnd);
        maxLength = Math.max(windowEnd - windowStart + 1, maxLength);
      }
      return maxLength;
    }

    public static void main(String[] args) {
      System.out.println("Length of the longest substring: " + findLength("aabccbb"));
      System.out.println("Length of the longest substring: " + findLength("abbbb"));
      System.out.println("Length of the longest substring: " + findLength("abccde"));
      System.out.println("Length of the longest substring: " + findLength("abbbcdeabbba"));
      System.out.println("Length of the longest substring: " + findLength("abcabcd"));
      /** mm output
       Length of the longest substring: 3
       Length of the longest substring: 2
       Length of the longest substring: 3
       Length of the longest substring: 4
       **/
    }

}
