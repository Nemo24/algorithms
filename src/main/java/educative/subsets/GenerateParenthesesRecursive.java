package educative.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesesRecursive {

  public static List<String> generateValidParentheses(int n) {
    List<String> result = new ArrayList<>();
    generateValidParentheses(0,0,0,new char[2*n],result,n);
    return result;

  }

  private static void generateValidParentheses(int index , int openNum , int closedNum ,char[] strArr,List<String> result,int size) {
    if (openNum == size && closedNum == size) {
      String s = new String(strArr);
      result.add(s);
      return;
    }

    if (openNum < size) {
      strArr[index] = '(';
      generateValidParentheses(index+1 , openNum+1 , closedNum , strArr,result,size);
    }

    if (openNum > closedNum ) {
      strArr[index] = ')';
      generateValidParentheses(index+1 , openNum , closedNum + 1 , strArr,result,size);
    }
  }

  public static void main(String[] args) {
    List<String> result = GenerateParenthesesRecursive.generateValidParentheses(2);
    System.out.println("All combinations of balanced parentheses are: " + result);

    result = GenerateParenthesesRecursive.generateValidParentheses(3);
    System.out.println("All combinations of balanced parentheses are: " + result);
  }
}
