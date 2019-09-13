package puzzles;

import java.util.Arrays;
import java.util.List;

public class KeyPad {
  List<String> strings ;

  public KeyPad(List<String> strings) {
    this.strings = strings;
  }

  public void recurse(List<String> tobepicked,StringBuilder accum,int picked){
    //System.out.println(String.format(" tobepicked %s accum %s picked %s",tobepicked.toString(),accum,picked));
    if (tobepicked.size() == 0) {
      if (picked==strings.size() ) {
        System.out.println(accum.toString());
      }
      return;
    }
    for (int k = 0 ;k<tobepicked.size();k++) {
      String s= tobepicked.get(k);
      char[] array = s.toCharArray();
      for (int i = 0; i < array.length; i++) {
         accum.append(array[i]);
         recurse(tobepicked.subList(k+1,tobepicked.size()),accum,picked+1);
         accum.deleteCharAt(accum.lastIndexOf(array[i]+""));

      }
    }
  }

  public static boolean isPal(String a) {
    String b = a.toLowerCase();
    for (int i = 0; i < b.length()/2; i++) {
      if(b.charAt(i) != b.charAt(a.length()-1-i)) {
        return false;
      }

    }
    return true;
  }

  public static void main(String[] args) {

/*   String a = "aba";
    System.out.println(isPal("aba"));
    System.out.println(isPal("aBba"));
    System.out.println(isPal("axba"));
    System.out.println(isPal("rever"));
    System.out.println(isPal("revver"));
    System.out.println(isPal("reever"));
    System.out.println(isPal("Deleveled"));*/

    String[] strings = {"abc","def","ghi","jkl"};
    List<String> stringList = Arrays.asList(strings);
    KeyPad mm = new KeyPad(stringList);
    StringBuilder s = new StringBuilder();
    mm.recurse(stringList,s,0);
    }


}

