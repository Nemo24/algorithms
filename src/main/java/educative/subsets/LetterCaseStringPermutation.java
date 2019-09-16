package educative.subsets;
import java.util.*;

/***
 * Given a string, find all of its permutations preserving the character sequence but changing case.
 * Input: "ad52"
 * Output: "ad52", "Ad52", "aD52", "AD52"
 *
 * Input: "ab7c"
 * Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 */
class LetterCaseStringPermutation {

  public static List<String> findLetterCaseStringPermutations(String str) {
    List<String> permutations = new ArrayList<>();
    char[] strArray = str.toCharArray();
    findLetterCaseStringPermutations(0,strArray,permutations);
    return permutations;
  }

  public static void findLetterCaseStringPermutations( int index,char[] accum,List<String> result) {
   // System.out.println("index " + index + " accum " + accum);
    if (index >= accum.length ) {
      StringBuilder builder = new StringBuilder();
      builder.append(accum);
      result.add(builder.toString());
      return;
    }

    // choose
      char before = accum[index];
      if (Character.isAlphabetic(before)) {
        accum[index] = Character.toUpperCase(accum[index]);
        //explore
        findLetterCaseStringPermutations(index + 1, accum, result);
        //unchoose
        accum[index] = before;
        // do this for the unchanged version as well
        findLetterCaseStringPermutations(index + 1, accum, result);
      } else {
        findLetterCaseStringPermutations(index + 1, accum, result);

      }



  }

  public static void main(String[] args) {
   List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
    System.out.println(" String permutations are: " + result );

    result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
    System.out.println(" String permutations are: " + result);

    result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab");
    System.out.println(" String permutations are: " + result);
  }
}
