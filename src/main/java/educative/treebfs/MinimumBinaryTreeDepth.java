package educative.treebfs;

import java.util.LinkedList;
import java.util.Queue;

class MinimumBinaryTreeDepth {
  public static int findDepth(TreeNode root) {
    if (root == null) return -1;
    int minDepth = Integer.MAX_VALUE;
    int depth = 1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left!=null) queue.offer(node.left);
        if (node.right!=null) queue.offer(node.right);
        if (isLeaf(node)) {
          minDepth = Math.min(minDepth,depth);
        }
      }
      depth++;

    }
    return minDepth;
  }

  private static boolean  isLeaf(TreeNode node) {
    return (node.left==null) && (node.right==null);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    root.left.left = new TreeNode(9);
    root.right.left.left = new TreeNode(11);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
  }
}