package main.java.puzzles;

/***
 * given a kArr array [a,b,c]
 * generate all string on n length
 * if n == 1 [a],[b],[c] n == 2 [aa][ab][ac][ba][bb][bc],[ca],[cb],[cc]
 * etc
 */
public class AllStringSWithKAlphabets {
  int n;
  String[] kArr;
  String[] outPut;

  public AllStringSWithKAlphabets(String[] kArr,int n) {
    this.kArr = kArr;
    this.n = n;
    outPut = new String[n];
  }

  public void k_string(){
    k_string(n);
  }

  private void k_string(int n) {
    if (n < 1) {
      print();
    } else {
      for (int i = 0; i < kArr.length; i++) {
        outPut[n - 1] = kArr[i];
        k_string(n-1 );
      }
    }
  }

  private void print() {
    System.out.printf(" output ");
    for (int i = 0; i < n; i++) {
      System.out.printf(outPut[i] +" ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    String[] kArr = {"a","b","c"};
    AllStringSWithKAlphabets mm = new AllStringSWithKAlphabets(kArr,3);
    mm.k_string();
  }
}
