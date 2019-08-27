package educative.treebfs;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;


class ReverseLevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    if (root == null)
      return result;

    Queue<TreeNode> queue = new LinkedBlockingDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> currLevel = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.remove();
        currLevel.add(node.val);
        if (node.left!=null)
          queue.add(node.left);
        if (node.right!=null)
          queue.add(node.right);
      }
      result.addFirst(currLevel);
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
    System.out.println("Reverse level order traversal: " + result);
  }
}
