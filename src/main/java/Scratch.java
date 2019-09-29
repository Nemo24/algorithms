import java.util.HashMap;
import java.util.Map;

import java.util.*;

class Scratch {

  public static List<List<Integer>> findPermutations(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> current =new ArrayList<>();
    perm(nums,result,current);
    return result;
  }
  
  public static void perm(int[] nums,List<List<Integer>> result , ArrayList<Integer> current) {
    System.out.println("nums"+ nums.length + "current " + current);
    if (nums.length == 0) {
      ArrayList<Integer> currentCopy = new ArrayList<>();
      for (int c : current) {
        currentCopy.add(c);
      }
      result.add(currentCopy);
      return;
      
    }

    for (int i = 0; i < nums.length; i++) {
      int[] restOfArray = restOfArray(nums,i);
      //choose
      current.add(nums[i]);
      //explore
      perm(restOfArray,result,current);
      //unchoose
      current.remove(current.size()-1);
    }
  }

  public static int[] restOfArray(int[] nums,int index) {
    int[] rest = new int[nums.length -1];
    int i = 0,j=0;
    while ( i < rest.length) {
      if (j!=index) {
        rest[i]  = nums[j];
        i++;
      }
      j++;
    }
    return rest;
  }

    public static boolean isPerfectSquare(int num) {
      if (num == 1) return true;
      if (num == 2) return false;
      int start = 2;
      int end = num /2;

      while (start <= end) {
        int mid = start + (end - start)/2;
        long sq = (long) mid * mid ;
        System.out.println(String.format("start %s end %s mid %s sq %s",start,end,mid,sq));
        if (sq > num) {
          end = mid -1;
        } else if (sq < num) {
          start = mid + 1;
        } else {
          return true;
        }
      }
      System.out.println(String.format("start %s end %s ",start,end));
      return start == end;
    }

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String,List<String>> sortedStringMap = new HashMap();
    for(int i = 0;i< strs.length;i++) {
      char[] strArr = strs[i].toCharArray();
      Arrays.sort(strArr);

      String s = new String(strArr);
      if (sortedStringMap.containsKey(s)) {
        sortedStringMap.get(s).add(strs[i]);
      } else {
        List<String> list = new ArrayList<>();
        list.add(strs[i]);
        sortedStringMap.put(s,list);
      }
    }

    List<List<String>> res = new ArrayList();
    sortedStringMap.values().forEach(i -> res.add(i));
    return res;
  }

  public static void main(String[] args) {
    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> res = groupAnagrams(strs);
    System.out.println(res);

    //List<List<Integer>> result = Scratch.findPermutations(new int[] { 1, 2,3,4 });
    StringBuilder builder  = new StringBuilder();
    builder.deleteCharAt(builder.length()-1);
  }
}
