package educative.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Example 1:
 *
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 * Example 2:
 *
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
public class StringAnagrams {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
      List<Integer> resultIndices = new ArrayList<Integer>();
      int windowStart = 0;
      int patternLen = pattern.length();
      for (int windowEnd = 0 ; windowEnd < str.length();windowEnd++) {

        if (windowEnd >= patternLen - 1) {
          String curr = str.substring(windowStart, windowEnd + 1);
          if (checkEquals(curr, pattern)) {
            resultIndices.add(windowStart);
          }
            windowStart++;
        }
      }
      return resultIndices;
    }

    public static boolean checkEquals(String s1,String s2 ) {
    char[] s1Arr = s1.toCharArray();
    char[] s2Arr = s2.toCharArray();
    Arrays.sort(s1Arr);
    Arrays.sort(s2Arr);
    if (s1Arr.length!=s2Arr.length) return false;
    for (int i = 0; i < s2Arr.length; i++) {
      if (s1Arr[i]!=s2Arr[i]) return  false;

    }
    return true;
  }

    public static void main(String[] args) {
      System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
      System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }

}
