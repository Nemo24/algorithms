package leetcode.printleaves;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import leetcode.TreeNode;

class PrintLeaves {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> listOfLists = new ArrayList<>();
    if (root == null) return listOfLists;
    while ( !isLeaf(root)) {
      List<Integer> listInt  = new ArrayList();
      dfs(root,root.left,true,listInt);
      dfs(root,root.right,false,listInt);
      listOfLists.add(listInt);
    }
    listOfLists.add( Arrays.asList(root.val));
    return listOfLists;
  }

  private void dfs(TreeNode parent,TreeNode node,boolean isLeft,List<Integer> list) {
    if (node == null) return ;
    if (isLeaf(node)) {
      if (isLeft) parent.left = null;
      else parent.right = null;
      list.add(node.val);
      return;
    }
    dfs(node,node.left,true,list);
    dfs(node,node.right,false,list);
  }

  private boolean isLeaf(TreeNode node) {
    return (node.left == null) && (node.right == null);
  }
}
public class MainClass {
  public static TreeNode stringToTreeNode(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return null;
    }

    String[] parts = input.split(",");
    String item = parts[0];
    TreeNode root = new TreeNode(Integer.parseInt(item));
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    nodeQueue.add(root);

    int index = 1;
    while(!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int leftNumber = Integer.parseInt(item);
        node.left = new TreeNode(leftNumber);
        nodeQueue.add(node.left);
      }

      if (index == parts.length) {
        break;
      }

      item = parts[index++];
      item = item.trim();
      if (!item.equals("null")) {
        int rightNumber = Integer.parseInt(item);
        node.right = new TreeNode(rightNumber);
        nodeQueue.add(node.right);
      }
    }
    return root;
  }

  public static String integerArrayListToString(List<Integer> nums, int length) {
    if (length == 0) {
      return "[]";
    }

    String result = "";
    for(int index = 0; index < length; index++) {
      Integer number = nums.get(index);
      result += Integer.toString(number) + ", ";
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  public static String integerArrayListToString(List<Integer> nums) {
    return integerArrayListToString(nums, nums.size());
  }

  public static String int2dListToString(List<List<Integer>> nums) {
    StringBuilder sb = new StringBuilder("[");
    for (List<Integer> list: nums) {
      sb.append(integerArrayListToString(list));
      sb.append(",");
    }

    sb.setCharAt(sb.length() - 1, ']');
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      TreeNode root = stringToTreeNode(line);

      List<List<Integer>> ret = new Solution().findLeaves(root);

      String out = int2dListToString(ret);

      System.out.print(out);
    }
  }
}

class Solution {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();

    if (root == null) {
      return ans;
    }

    findLeavesHelper(root, ans);

    return ans;
  }

  private int findLeavesHelper(TreeNode root, List<List<Integer>> ans) {
    if (root == null) {
      return -1;
    }

    int left = findLeavesHelper(root.left, ans);
    int right = findLeavesHelper(root.right, ans);

    int depth = Math.max(left, right) + 1;
    System.out.println("depth " + depth + " ans size " + ans.size() + " node " + root.val);
    if (depth == ans.size()) {
      List<Integer> list = new ArrayList<>();
      list.add(root.val);
      ans.add(list);
    } else {
      List<Integer> list = ans.get(depth);
      list.add(root.val);
    }


    return depth;
  }
}
