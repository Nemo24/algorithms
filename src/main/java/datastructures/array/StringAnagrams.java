package datastructures.array;

/**
 * Created by mm on 15/1/16.
 */
public class StringAnagrams {
    int[] wordcount = new int[256];
    public boolean anagrams(String a,String b) {
        if ((a==null) || (b ==null)) return false;
        if (a.length()!=b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            wordcount[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            if (--wordcount[b.charAt(i)] < 0 ) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StringAnagrams mm = new StringAnagrams();
        System.out.println(mm.anagrams("abc","bca")+ "");
        System.out.println(mm.anagrams("abc","bcaa")+ "");
        System.out.println(mm.anagrams("ass","saa")+ "");
    }
}
