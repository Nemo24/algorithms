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

  public static void main(String[] args) {
    List<List<Integer>> result = Scratch.findPermutations(new int[] { 1, 2,3,4 });
    System.out.print("Here are all the permutations: " + result);
  }
}
