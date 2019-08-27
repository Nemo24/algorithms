package datastructures.string;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by mm on 6/3/16.
 */
public class LongestRepeatedSubstring {
    String[] suffixTree ;
    public String lrs(String s){
        int length  = s.length();
        suffixTree = new String[s.length()];
        for (int i = 0; i < length; i++) {
            suffixTree[i] = s.substring(i);
        }
        Arrays.sort(suffixTree);
        String longestRepeatd="";
        for (int i = 0; i < length -1; i++) {
            String suffix = lowestCommonPrefix(suffixTree[i],suffixTree[i+1]);
            if (suffix.length() > longestRepeatd.length()){
                longestRepeatd = suffix;
            }
        }
        return longestRepeatd;
    }
    private String lowestCommonPrefix(String s1,String s2){
        int len = Math.min(s1.length(),s2.length());
        int i = 0;
        StringBuilder str = new StringBuilder();
        while (i < len && s1.charAt(i)==s2.charAt(i)){
            str.append(s1.charAt(i));
            i++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        LongestRepeatedSubstring lrs = new LongestRepeatedSubstring();
        System.out.println(lrs.lrs("abcdddweddhelloaadsceeehellodsjs"));
    }
}
