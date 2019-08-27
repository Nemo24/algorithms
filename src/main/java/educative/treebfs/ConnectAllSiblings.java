package educative.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {
  public static void connect(TreeNode1 root) {
    if (root == null) return;
    Queue<TreeNode1> queue = new LinkedList<>();
    queue.offer(root);
    TreeNode1 prev = null;
    while (!queue.isEmpty()) {
      TreeNode1 node = queue.poll();
      if (prev!=null) prev.next = node;
      prev = node;
      if (node.left!=null) queue.offer(node.left);
      if (node.right!=null) queue.offer(node.right);

    }
  }

  public static void main(String[] args) {
    TreeNode1 root = new TreeNode1(12);
    root.left = new TreeNode1(7);
    root.right = new TreeNode1(1);
    root.left.left = new TreeNode1(9);
    root.right.left = new TreeNode1(10);
    root.right.right = new TreeNode1(5);
    ConnectAllSiblings.connect(root);

    // level order traversal using 'next' pointer
    TreeNode1 current = root;
    System.out.println("Traversal using 'next' pointer: ");
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}