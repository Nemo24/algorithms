package puzzles;

import java.util.Arrays;
import java.util.List;

public class PhonePad {

  public static void printAllCombs(List<String> strings) {
    StringBuilder stringBuilder = new StringBuilder();
    printAllCombs(strings,stringBuilder);

  }

  private static void printAllCombs(List<String> strings,StringBuilder s) {
    if (strings.size() == 0) {
      System.out.println(s.toString());
    }
    for(String str : strings) {
      for(int i = 0 ; i< str.length();i++) {
        s.append(str.charAt(i));
        strings.remove(str);
        printAllCombs(strings,s);
        strings.add(str);
        s.deleteCharAt(s.lastIndexOf(str.charAt(i)+""));
      }
    }
  }

  public static void main(String[] args) {
    String[] phonePad = {"abc","def","ghi"};
    printAllCombs(Arrays.asList(phonePad));
  }
}
