package educative.treedfs;

public class TreePathSum {
  public static boolean hasPath(TreeNode root, int sum) {

    return hasPath(root,sum,0);
  }
  public static  boolean hasPath(TreeNode root, int sum, int currSum) {
    if (root == null) {
      if (currSum == sum) return true;
      else return false;
    }

    return hasPath(root.left,sum,currSum+root.val)
        || hasPath(root.right,sum,currSum+root.val);

  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
  }
}