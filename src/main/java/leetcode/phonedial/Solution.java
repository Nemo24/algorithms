package leetcode.phonedial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  Map<Character,String> digitLetterMap = new HashMap();
  public Solution() {
    digitLetterMap.put('2',"abc");
    digitLetterMap.put('3',"def");
    digitLetterMap.put('4',"ghi");
    digitLetterMap.put('5',"jkl");
    digitLetterMap.put('6',"mno");
    digitLetterMap.put('7',"pqrs");
    digitLetterMap.put('8',"tuv");
    digitLetterMap.put('9',"wxyz");
  }
  public List<String> letterCombinations(String digits) {
    char[] digitArr = digits.toCharArray();
    List<String> res = new ArrayList();
    letterCombinations(digitArr,"",0,res);
    return res;
  }

  private void letterCombinations(char[] digitArr,String chosen,int index,List<String> result) {
    if ((index == digitArr.length)) {
      result.add(chosen);
      return ;
    }

    String d = digitLetterMap.get(digitArr[index]);
    for (int i = 0 ; i < d.length();i++) {
      letterCombinations(digitArr,chosen + d.charAt(i),index+1,result);
    }

  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<String> stringList = solution.letterCombinations("234");
    System.out.println(stringList);
  }
}

