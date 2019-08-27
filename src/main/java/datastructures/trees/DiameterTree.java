package datastructures.trees;

/**
 * Created by mm on 17/1/16.
 */
public class DiameterTree {
    int diameter =0;
    public int diameter(BinaryTree tree){
        if (tree == null) return 0;

        return    diameter(tree.root);
    }
    public int diameterKarumanchi(BinaryTreeNode root){
        if (root == null) return 0;
        int left,right;
        left = diameterKarumanchi(root.getLeft());
        right = diameterKarumanchi(root.getRight());
        if (diameter < (left+right))diameter = left+right;
        return Math.max(left,right)+1;

    }
    private int diameter(BinaryTreeNode root) {
        if (root == null) return 0;
        int lheight = height(root.getLeft());
        int rheight = height(root.getRight());
        int ldiameter  = diameter(root.getLeft());
        int rdiameter  = diameter(root.getRight());
        return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));
    }

    private int height(BinaryTreeNode node){
    if (node ==null) return 0;
        return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }

    public static void main(String[] args) {
        DiameterTree mm = new DiameterTree();
        BinaryTree tree = BinaryTreeCreatorHelper.getBinaryTreeExample3();
        System.out.println(""+mm.diameter(tree));
        mm.diameterKarumanchi(tree.root);
        System.out.println(""+mm.diameter);
    }
}
