package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/***
 * Example 1:
 *
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 * Example 2:
 *
 * Input: String="abdabca", Pattern="abc"
 * Output: "abc"
 * Explanation: The smallest substring having all characters of the pattern is "abc".
 * Example 3:
 *
 * Input: String="adcad", Pattern="abc"
 * Output: ""
 * Explanation: No substring in the given string has all characters of the pattern.
 */
public class MinimumWindowSubstring {
  public static String findPermutation(String str, String pattern) {
    Map<Character,Integer> charFreqMap = new HashMap<>();

    //populate freq table
    for (int i = 0; i < pattern.length(); i++) {
      char current = pattern.charAt(i);
      charFreqMap.put(current,charFreqMap.getOrDefault(current,0)+1);
    }
    int windowStart = 0;
    int matched = 0;
    String matchSubStr =null;
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar  = str.charAt(windowEnd);
      if (charFreqMap.containsKey(rightChar)) {
        charFreqMap.put(rightChar,charFreqMap.get(rightChar) -1);
        if (charFreqMap.get(rightChar) == 0) {
          matched++;
        }
      }
      if (matched == charFreqMap.size()) {
        while (matched == charFreqMap.size()) {
          char leftChar = str.charAt(windowStart);
          if (charFreqMap.containsKey(leftChar)) {
            charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
            if (charFreqMap.get(leftChar) == 0) {
              matched--;
            }
          }
          windowStart++;
        }
        if (matchSubStr == null) {
          matchSubStr = str.substring(windowStart,windowEnd+1);
        } else {
          if (str.substring(windowStart,windowEnd+1).length() < matchSubStr.length()) {
            matchSubStr = str.substring(windowStart,windowEnd+1);
          }
        }


        return matchSubStr;
      }



    }
    return "not found";
  }

  public static void main(String[] args) {
   // System.out.println(MinimumWindowSubstring.findPermutation("aabdec", "abc"));
    System.out.println(MinimumWindowSubstring.findPermutation("abdabca", "abc"));
   // System.out.println(MinimumWindowSubstring.findPermutation("adcad", "abc"));
  }
}
