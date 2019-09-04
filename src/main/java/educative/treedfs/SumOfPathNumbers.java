package educative.treedfs;

/***
 * Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number. Find the total sum of all the numbers represented by all paths.
 *     1
 *   7  9
 *     2  9
 *  Example 1:
 *  Output: 408 Explaination: The sume of all path numbers: 17 + 192 + 199
 */

public class SumOfPathNumbers {
  public static int findSumOfPathNumbers(TreeNode root) {
    return findSumPath(root,0);
  }
  public static int findSumPath(TreeNode node , int sum) {
    if (node == null) return 0;
    if ((node.left==null) && (node.right == null)) return sum * 10 + node.val;
    return findSumPath(node.left,sum*10 + node.val)
        + findSumPath(node.right,sum*10 + node.val);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}