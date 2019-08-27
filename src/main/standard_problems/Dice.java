
import java.util.ArrayList;

public class Dice {

  public static void dice(int n) {
    dice(n,new ArrayList());
  }

  private static void dice(int n, ArrayList list) {
    if (n == 0) {
      // base case
      System.out.println(list);
    } else {
      for (int i = 1; i <= 6; i++) {
         list.add(i); // choose
         dice(n - 1,list); //explore or recurse
         list.remove(list.size() - 1); // un choose

      }
    }
  }

  public static void main(String[] args) {
    dice(3);
  }
}
