package datastructures.trees;

/**
 * Created by mm on 16/1/16.
 */
public class StruturallyIdentical {
    public boolean identical(BinaryTreeNode root1 , BinaryTreeNode root2) {
        if ((root1==null) && ( root2 ==null)) return true;
        if ((root1==null) || ( root2 ==null)) return false;
        if (root1.getData()!=root2.getData()) return false;

        return identical(root1.getLeft(),root2.getLeft()) && identical(root1.getRight(),root2.getRight());
    }

    public static void main(String[] args) {
        StruturallyIdentical mm = new StruturallyIdentical();
        BinaryTree tree1 = BinaryTreeCreatorHelper.getBinaryTreeExample();
        BinaryTree tree2 = BinaryTreeCreatorHelper.getBinaryTreeExample();
        System.out.println("structurally identical "  +mm.identical(tree1.root,tree2.root));
        BinaryTree tree3 = BinaryTreeCreatorHelper.getBinaryTreeExample2();
        System.out.println("structurally identical "  +mm.identical(tree1.root,tree3.root));


    }


}
