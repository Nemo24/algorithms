package datastructures.trees;

/**
 * Created by mm on 30/8/15.
 */
public class BinaryTreeNode {
    final int SPACE = 4;
   private  int data;
    private BinaryTreeNode left;

    private BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public void printlevel(int level,BinaryTreeNode n){
        if (n ==null) return;
        for (int i = 0; i < level; i++) {
            System.out.printf(" ");
        }
        System.out.print(n.getData() + "");
        System.out.println("");
        printlevel(level - 2*SPACE, n.getLeft());
        printlevel(level + 2 * SPACE, n.getRight());
    }
}
