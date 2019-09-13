package recursionandbacktrack;

public class PrintBinary {
  public static void printBinary(int n) {
    printBinary(n,"");
  }

  private static void printBinary(int n , String s) {
    if (n == 0) {
      System.out.println(s);
      return;
    }
    printBinary(n-1,s + "0");
    printBinary(n-1,s + "1");
  }


  public static void main(String[] args) {
    printBinary(3);
  }
}
