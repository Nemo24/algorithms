import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubSets {

  public static List<Set<String>> subSets(ArrayList<String> names) {
    List<Set<String>> result = new ArrayList<>();
    subSets(names,result,new HashSet<>());
    return result;
  }

  private static void subSets(ArrayList<String> names,List<Set<String>> result, Set<String> chosen) {
    System.out.println(String.format(" in subSets names %s chosen %s",names , chosen));
    if (names.isEmpty()) {
      Set<String> copySet = new HashSet<>();
      chosen.forEach(i -> copySet.add(i));
;     result.add(copySet);
      return;
    }

    String remove = names.remove(0);
    subSets(names,result,chosen);
    chosen.add(remove);
    subSets(names,result,chosen);
    chosen.remove(remove);
    names.add(remove);

  }
  public static void main(String[] args) {
    String[] names = {"JANE","BOB","MATT","SARA"};
    //String[] names = {"A","B","C"};

    ArrayList<String> list = new ArrayList<>();
    for (String name : names) {
      list.add(name);
    }
    List<Set<String>> subset = subSets(list);
    System.out.println(subset);
  }
}
