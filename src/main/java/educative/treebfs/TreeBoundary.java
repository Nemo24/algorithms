package educative.treebfs;

import java.util.*;

public class TreeBoundary {
  public static List<TreeNode> findBoundary(TreeNode root) {
    List<TreeNode>result = new ArrayList<>();

    if (root == null) return result ;

    List<TreeNode> resultLeft = new ArrayList<>();
    List<TreeNode> resultRight = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left == null && node.right == null) // skip leaf nodes
          continue;
        if (size == 1) resultLeft.add(node);
        else if (i == 0) resultLeft.add(node);
        else if (i == size - 1) resultRight.add(0,node);
        if (node.left!=null) queue.offer(node.left);
        if (node.right!=null) queue.offer(node.right);
      }
    }
    result.addAll(resultLeft);
    result.addAll(getLeaves(root));
    result.addAll(resultRight);
    return result;
  }

  public static List<TreeNode> getLeaves(TreeNode root) {
    List<TreeNode> leaves = new ArrayList<>();
    if (root == null) return leaves;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
      TreeNode node = stack.pop();
      if ((node.left==null) && (node.right==null))
        leaves.add(node);
      if (node.right!=null) stack.push(node.right);
      if (node.left!=null) stack.push(node.left);
    }
    return leaves;
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(9);
    root.left.right = new TreeNode(3);
    root.left.right.left = new TreeNode(15);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    root.right.right.left = new TreeNode(6);
    List<TreeNode> result = TreeBoundary.findBoundary(root);
    for (TreeNode node : result) {
      System.out.print(node.val + " ");
    }
  }
}