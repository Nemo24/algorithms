package educative.treebfs;
import java.util.*;


class ConnectLevelOrderSiblings {
  public static void connect(TreeNode1 root) {
    if (root == null) return;
    Queue<TreeNode1> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      TreeNode1 prev = null;
      for (int i = 0; i < size; i++) {
        TreeNode1 node = queue.poll();
        if (prev!=null) {
          prev.next = node;
        }
        prev = node;
        if (node.left!=null) queue.offer(node.left);
        if (node.right!=null) queue.offer(node.right);
      }
    }
  }

  public static void main(String[] args) {
    TreeNode1 root = new TreeNode1(12);
    root.left = new TreeNode1(7);
    root.right = new TreeNode1(1);
    root.left.left = new TreeNode1(9);
    root.right.left = new TreeNode1(10);
    root.right.right = new TreeNode1(5);
    ConnectLevelOrderSiblings.connect(root);
    System.out.println("Level order traversal using 'next' pointer: ");
    root.printLevelOrder();
  }

}
