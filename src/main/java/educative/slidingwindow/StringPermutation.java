package educative.slidingwindow;
import java.util.*;

/***
 * Example 1:
 *
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 * Example 2:
 *
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 * Example 3:
 *
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 * Example 4:
 *
 * Input: String="aaacb", Pattern="abc"
 * Output: true
 * Explanation: The string contains "acb" which is a permutation of the given pattern.
 */
class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    int windowStart = 0;
    int patternLen = pattern.length();
    for (int windowEnd = 0 ; windowEnd < str.length();windowEnd++) {

      if (windowEnd >= patternLen - 1) {
        String curr = str.substring(windowStart,windowEnd+1);
        if (checkEquals(curr,pattern)) return true;
        windowStart++;
      }
    }
    return false;
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
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
  }
}
