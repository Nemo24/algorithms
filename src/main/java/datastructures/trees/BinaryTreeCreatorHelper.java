package datastructures.trees;

/**
 * Created by mm on 1/3/16.
 */
public class BinaryTreeCreatorHelper {
    public static BinaryTree getBinarySearchTreeCorrect(){
        /*** Tree looks like this
         *
         *
         *                       5
         *            3                     7
         *        1       4           6         8
         *
         *
         */
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.setLeft(new BinaryTreeNode(3));
        root.setRight(new BinaryTreeNode(7));
        root.getLeft().setLeft(new BinaryTreeNode(1));
        root.getLeft().setRight(new BinaryTreeNode(4));
        root.getRight().setLeft(new BinaryTreeNode(6));
        root.getRight().setRight(new BinaryTreeNode(8));
        return new BinaryTree(root);
    }

    public static BinaryTree getBinarySearchTreeWrong(){
        /*** Tree looks like this
         *
         *
         *                       5
         *            3                     7
         *        1       9           6         8
         *
         *
         */
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.setLeft(new BinaryTreeNode(3));
        root.setRight(new BinaryTreeNode(7));
        root.getLeft().setLeft(new BinaryTreeNode(1));
        root.getLeft().setRight(new BinaryTreeNode(9));
        root.getRight().setLeft(new BinaryTreeNode(6));
        root.getRight().setRight(new BinaryTreeNode(8));
        return new BinaryTree(root);
    }
    public static BinaryTree getBinarySearchTreeVeryWrong(){
        /*** Tree looks like this
         *
         *
         *                       5
         *            3                     7
         *        1       2           6         8
         *
         *
         */
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.setLeft(new BinaryTreeNode(3));
        root.setRight(new BinaryTreeNode(7));
        root.getLeft().setLeft(new BinaryTreeNode(1));
        root.getLeft().setRight(new BinaryTreeNode(2));
        root.getRight().setLeft(new BinaryTreeNode(6));
        root.getRight().setRight(new BinaryTreeNode(8));
        return new BinaryTree(root);
    }

    public static BinaryTree getBinaryTreeExample(){
        /*** Tree looks like this
         *
         *
         *                       1
         *            2                     3
         *        4        5           6         7
         *
         *
         */
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.setLeft(new BinaryTreeNode(2));
        root.setRight(new BinaryTreeNode(3));
        root.getLeft().setLeft(new BinaryTreeNode(4));
        root.getLeft().setRight(new BinaryTreeNode(5));
        root.getRight().setLeft(new BinaryTreeNode(6));
        root.getRight().setRight(new BinaryTreeNode(7));
        return new BinaryTree(root);
    }

    public static BinaryTree getBinaryTreeExample2(){
        /*** Tree looks like this
         *
         *
         *                        1
         *            2                     3
         *       4        5           6         7
         *    8    9   10
         *
         */
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.setLeft(new BinaryTreeNode(2));
        root.setRight(new BinaryTreeNode(3));
        root.getLeft().setLeft(new BinaryTreeNode(4));
        root.getLeft().setRight(new BinaryTreeNode(5));
        root.getRight().setLeft(new BinaryTreeNode(6));
        root.getRight().setRight(new BinaryTreeNode(7));
        root.getLeft().getLeft().setLeft(new BinaryTreeNode(8));
        root.getLeft().getLeft().setRight(new BinaryTreeNode(9));
        root.getLeft().getRight().setLeft(new BinaryTreeNode(10));
        return new BinaryTree(root);
    }

    public static BinaryTree getOneSidedBinaryTreeExample(){
        /*** Tree looks like this
         *
         *
         *                        1
         *            2
         *       4        5
         *    8    9   10
         *
         */
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.setLeft(new BinaryTreeNode(2));
        root.getLeft().setLeft(new BinaryTreeNode(4));
        root.getLeft().setRight(new BinaryTreeNode(5));
        root.getLeft().getLeft().setLeft(new BinaryTreeNode(8));
        root.getLeft().getLeft().setRight(new BinaryTreeNode(9));
        root.getLeft().getRight().setLeft(new BinaryTreeNode(10));
        return new BinaryTree(root);
    }

    public static BinaryTree getBinaryTreeExample3(){
        /*** Tree looks like this
         *
         *
         *                        1
         *            2                     3
         *       4        5           6         7
         *    8    9   10  11       12  13    14  15
         *   16
         */
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.setLeft(new BinaryTreeNode(2));
        root.setRight(new BinaryTreeNode(3));
        root.getLeft().setLeft(new BinaryTreeNode(4));
        root.getLeft().setRight(new BinaryTreeNode(5));
        root.getRight().setLeft(new BinaryTreeNode(6));
        root.getRight().setRight(new BinaryTreeNode(7));
        root.getLeft().getLeft().setLeft(new BinaryTreeNode(8));
        root.getLeft().getLeft().setRight(new BinaryTreeNode(9));
        root.getLeft().getRight().setLeft(new BinaryTreeNode(10));
        root.getLeft().getRight().setRight(new BinaryTreeNode(11));
        root.getRight().getLeft().setLeft(new BinaryTreeNode(12));
        root.getRight().getLeft().setRight(new BinaryTreeNode(13));
        root.getRight().getRight().setLeft(new BinaryTreeNode(14));
        root.getRight().getRight().setRight(new BinaryTreeNode(15));
        root.getLeft().getLeft().getLeft().setLeft(new BinaryTreeNode(16));

        return new BinaryTree(root);
    }

    public static BinaryTree getBinaryTreeExampleUneven(){
        /*** Tree looks like this
         *
         *
         *                       1
         *            2                     3
         *        4        5                    7
         *
         *
         */
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.setLeft(new BinaryTreeNode(2));
        root.setRight(new BinaryTreeNode(3));
        root.getLeft().setLeft(new BinaryTreeNode(4));
        root.getLeft().setRight(new BinaryTreeNode(5));
        root.getRight().setRight(new BinaryTreeNode(7));
        return new BinaryTree(root);
    }

    public static BinaryTree getBinaryTreeExampleUneven2(){
        /*** Tree looks like this
         *
         *
         *                       1
         *            2                     3
         *        4        5                    7
         *
         *
         */
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.setLeft(new BinaryTreeNode(2));
        root.setRight(new BinaryTreeNode(3));
        root.getLeft().setLeft(new BinaryTreeNode(4));
        root.getRight().setRight(new BinaryTreeNode(7));
        return new BinaryTree(root);
    }
}
