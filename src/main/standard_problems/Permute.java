import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import puzzles.CrossWord;

public class Permute {
  private List<List<String>> permWords(List<String> words) {
    List<List<String>> perms = new ArrayList<>();
    List<String> accum = new ArrayList<>();
    permWords(perms,accum,words);
    return perms;
  }

  public void permWords(List<List<String>> perms,List<String> accum,List<String> words) {
    if (words.size() == 0) {
      perms.add(accum.stream().collect(Collectors.toList()));
      return ;
    }
    for (String word:words){
      accum.add(word);
      permWords(perms,accum,words.stream().filter(i -> !i.equals(word)).collect(Collectors.toList()));
      accum.remove(word);
    }

  }
  public static void main(String[] args) {
    Permute permute = new Permute();
    String[] words = {"M","A","R","T","Y"};
    List<List<String>> lists = permute.permWords(Arrays.asList(words));
    lists.forEach(i -> System.out.println(i.toString()));

  }
}
