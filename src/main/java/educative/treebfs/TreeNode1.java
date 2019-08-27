package educative.treebfs;

public class TreeNode1 {
  int val;
  TreeNode1 left;
  TreeNode1 right;
  TreeNode1 next;

  TreeNode1(int x) {
    val = x;
    left = right = next = null;
  }

  // level order traversal using 'next' pointer
  void printLevelOrder() {
    TreeNode1 nextLevelRoot = this;
    while (nextLevelRoot != null) {
      TreeNode1 current = nextLevelRoot;
      nextLevelRoot = null;
      while (current != null) {
        System.out.print(current.val + " ");
        if (nextLevelRoot == null) {
          if (current.left != null)
            nextLevelRoot = current.left;
          else if (current.right != null)
            nextLevelRoot = current.right;
        }
        current = current.next;
      }
      System.out.println();
    }
  }
};
