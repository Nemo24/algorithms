package educative.treebfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class LevelAverage {
  public static List<Double> findLevelAverages(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedBlockingDeque();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      Double sum = 0.0;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.remove();
        sum+= node.val;
        if (node.left!=null)
          queue.add(node.left);
        if (node.right!=null)
          queue.add(node.right);
      }
      result.add(sum/size);
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<Double> result = LevelAverage.findLevelAverages(root);
    System.out.print("Level averages are: " + result);
  }
}
