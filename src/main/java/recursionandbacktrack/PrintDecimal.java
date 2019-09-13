package recursionandbacktrack;

public class PrintDecimal {
  public static void printDecimal(int n) {
    printDecimal(n,"");
  }

  private static void printDecimal(int n , String s) {
    if (n == 0) {
      System.out.println(s);
      return;
    }
    for (int i = 0; i < 10; i++) {
      printDecimal(n-1,s + i);
    }
  }
  
  
  public static void main(String[] args) {
    printDecimal(3);
  }
}
