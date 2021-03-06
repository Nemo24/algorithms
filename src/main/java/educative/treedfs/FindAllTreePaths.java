package educative.treedfs;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    findPaths(root,sum,new ArrayList<>(),allPaths);
    return allPaths;
  }

  public static void findPaths(TreeNode root,int sum, List<Integer> currPath,List<List<Integer>> allPaths) {
    if (root == null) return;
    currPath.add(root.val);

    if ((root.val == sum) && (root.left == null) && (root.right == null)) {
      List<Integer> list =new ArrayList<>();
      list.addAll(currPath);
      allPaths.add(list);
      return;
    }

    findPaths(root.left,sum - root.val,currPath,allPaths);
    findPaths(root.right,sum - root.val,currPath,allPaths);

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}