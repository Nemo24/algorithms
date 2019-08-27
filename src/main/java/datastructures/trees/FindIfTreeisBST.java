package datastructures.trees;

/**
 * Created by mm on 1/3/16.
 */
public class FindIfTreeisBST {
    int prev = Integer.MIN_VALUE;
    public boolean isBSTWrongApproach(BinaryTree tree){
        if (tree == null) return false;
        return isBSTWrongApproach(tree.root);
    }
    private boolean isBSTWrongApproach(BinaryTreeNode root){
        if (root == null) return  true;
        if ((root.getLeft()!=null) && (root.getLeft().getData() > root.getData())) return false;
        if ((root.getRight()!=null) && (root.getRight().getData() < root.getData())) return false;
        return isBSTWrongApproach(root.getLeft()) && isBSTWrongApproach(root.getRight());
    }
    public boolean isBST(BinaryTree tree){
        if (tree == null) return false;
        prev = Integer.MIN_VALUE;
        return isBST(tree.root);
    }
    private boolean isBST(BinaryTreeNode root){
        if (root == null) return true;
        boolean leftIsTrue = isBST(root.getLeft());
        if (!leftIsTrue) return false;
        if (root.getData() < prev) return false;
        prev = root.getData();
        return isBST(root.getRight());
    }
    public static void main(String[] args) {
        BinaryTree tree1 = BinaryTreeCreatorHelper.getBinarySearchTreeWrong();
        BinaryTree tree2 = BinaryTreeCreatorHelper.getBinarySearchTreeCorrect();
        BinaryTree tree3 = BinaryTreeCreatorHelper.getBinarySearchTreeVeryWrong();
        FindIfTreeisBST mm = new FindIfTreeisBST();
        System.out.println("wrong approach");

        System.out.println(mm.isBSTWrongApproach(tree1) + ":this should be false");
        System.out.println(mm.isBSTWrongApproach(tree2) + ":this could be true");
        System.out.println(mm.isBSTWrongApproach(tree3) + ":this should be false");
        System.out.println();
        System.out.println("right approach");
        System.out.println(mm.isBST(tree1) + ":this should be false");
        System.out.println(mm.isBST(tree2) + ":this could be true");
        System.out.println(mm.isBST(tree3) + ":this should be false");
    }
}
