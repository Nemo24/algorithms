package datastructures.trees;

/**
 * Created by mm on 27/2/16.
 */
public class MirrorABinaryTree {
    public void mirrorTree(BinaryTree tree){
        if (tree == null) return;
        mirrorTree(tree.root);
    }
    private void mirrorTree(BinaryTreeNode node){

    }

    public static void main(String[] args) {
        MirrorABinaryTree mm = new MirrorABinaryTree();

    }
}
