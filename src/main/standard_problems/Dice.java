package main.standard_problems;

import java.util.ArrayList;

public class Dice {

  public static void dice(int n) {
    dice(n,new ArrayList());
  }

  private static void dice(int n, ArrayList list) {
    if (n == 0) {
      System.out.println(list);
    } else {
      for (int i = 1; i <= 6; i++) {
         list.add(i);
         dice(n - 1,list);
         list.remove(list.size() - 1);

      }
    }
  }

  public static void main(String[] args) {
    dice(3);
  }
}
