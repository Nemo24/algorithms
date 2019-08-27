package datastructures.trees;

/**
 * Created by mm on 16/1/16.
 */
public class LowestCommonAncestor {
    public BinaryTreeNode lca(BinaryTreeNode root,BinaryTreeNode node1,BinaryTreeNode node2) {
        if ( root ==null) return  root;
        if ((root == node1 ) || (root == node2)) return root;
        BinaryTreeNode left = lca(root.getLeft(),node1,node2);
        BinaryTreeNode right = lca(root.getRight(),node1,node2);
        if ( (left!=null) && (right!=null)) return root;
        if (left!=null) return left;
        else return right;
    }

    public static void main(String[] args) {
        BinaryTree tree = BinaryTreeCreatorHelper.getBinaryTreeExample();
        LowestCommonAncestor mm = new LowestCommonAncestor();
        BinaryTreeNode node1 = tree.root.getLeft().getLeft();
        BinaryTreeNode node2 = tree.root.getLeft().getLeft();
        BinaryTreeNode node3 = tree.root.getRight().getLeft();
        BinaryTreeNode node4 = tree.root.getRight().getRight();
        BinaryTreeNode lca1 = mm.lca(tree.root,node1,node2);
        BinaryTreeNode lca2 = mm.lca(tree.root,node1,node3);
        BinaryTreeNode lca3 = mm.lca(tree.root,node3,node4);
        System.out.println("lca is "+lca1.getData());
        System.out.println("lca is "+lca2.getData());
        System.out.println("lca is "+lca3.getData());

    }
}
