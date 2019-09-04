package educative.treedfs;

/***
 * Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
 *
 *     1
 *   7  9
 *     2  9
 *  Example 1:
 *  Sequence: [1, 9, 9]Output: true Explaination: The tree has a path 1 -> 9 -> 9.
 */
public class PathWithGivenSequence {
  public static boolean findPath(TreeNode root, int[] sequence) {
    return findPath(root,sequence,0);
  }

  public static boolean findPath(TreeNode node,int[] sequence, int currIndex) {
    if (node == null) return false;
    if ((node.left == null) && (node.right == null)) {
      return node.val == sequence[currIndex];
    }
    return findPath(node.left,sequence,currIndex+1)
        || findPath(node.right,sequence,currIndex+1);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);

    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
  }
}
