package educative.treebfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class ZigzagTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null)
      return result;

    Queue<TreeNode> queue = new LinkedBlockingDeque<>();
    queue.add(root);
    boolean leftToRight = true;
    while (!queue.isEmpty()) {
      List<Integer> currLevel = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.remove();
        currLevel.add(node.val);
        if (leftToRight) {
          if (node.left != null)
            queue.add(node.left);
          if (node.right != null)
            queue.add(node.right);
          leftToRight = false;
        } else {
          if (node.right != null)
            queue.add(node.right);
          if (node.left != null)
            queue.add(node.left);
        }
      }
      result.add(currLevel);
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
    root.right.left.left = new TreeNode(20);
    root.right.left.right = new TreeNode(17);
    List<List<Integer>> result = ZigzagTraversal.traverse(root);
    System.out.println("Zigzag traversal: " + result);
  }
}
