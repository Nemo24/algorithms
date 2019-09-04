package educative.treedfs;

/***
 * Given a binary tree and a number ‘S’, find all paths in the tree such that
 * the sum of all the node values of each path equals ‘S’.
 * Please note that the paths can start or end at any node but all paths must follow direction
 * from parent to child (top to bottom).
 *
 *  Example 1:
 *                  1
 *                7     9
 *              6  5  2   3
 *
 *        S: 12
 *        Output: 3
 *        Explaination: There are three paths with sum '12':7 -> 5, 1 -> 9 -> 2, and 9 -> 3
 */
public class CountAllPathSum {
  public static int countPaths(TreeNode root, int S) {
    if (root == null) return 0;
    if (isLeaf(root)) {
      if ((root.val == S) || (S ==0)) return 1;
      else return 0;
    }
    return countPaths(root.left,S)
        +  countPaths(root.left,S - root.val)
        +  countPaths(root.right,S)
        +  countPaths(root.right,S - root.val);

  }

  private static boolean isLeaf(TreeNode node) {
    return (node.left==null) && (node.right == null);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(7);
    treeNode.right = new TreeNode(9);
    treeNode.left.left = new TreeNode(6);
    treeNode.left.right = new TreeNode(5);

    treeNode.right.left = new TreeNode(2);
    treeNode.right.right = new TreeNode(3);
    System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 12));

  }
}
