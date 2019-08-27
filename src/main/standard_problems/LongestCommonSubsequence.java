public class LongestCommonSubsequence {

  String s1;
  String s2;
  char[] s1Arr;
  char[] s2Arr;
  int[][] lcsArr;

  public LongestCommonSubsequence(String s1, String s2) {
    this.s1 = s1;
    this.s2 = s2;
    s1Arr = s1.toCharArray();
    s2Arr = s2.toCharArray();
    lcsArr = new int[s1.length()][s2.length()];
  }

  public int lcs() {
    for (int i = 0; i < s1Arr.length; i++) {
      for (int j = 0; j < s1Arr.length; j++) {
        if (i == 0 || j == 0) {
          lcsArr[i][j] = 0;
        } else {
          if (s1Arr[i]==s2Arr[j]) {
            lcsArr[i][j] = 1 + lcsArr[i-1][j-1];
          } else {
            lcsArr[i][j] = Math.max(lcsArr[i][j-1],lcsArr[i-1][j]);
          }
        }

      }

    }
    return lcsArr[s1.length()-1][s2.length()-1];
  }

  public static  void lcs(String s1,String s2) {
    LongestCommonSubsequence instance = new LongestCommonSubsequence(s1,s2);
    int lcsVal = instance.lcs();
    System.out.println(String.format("longest increasing subsequence for %s and %s is %s",s1,s2,lcsVal));

  }

  public static void main(String[] args) {
    LongestCommonSubsequence.lcs("ABAEACFF","DACRADFF");
  }
}
