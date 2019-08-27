package datastructures.trees;

/**
 * Created by mm on 28/2/16.
 */
public class PrintAncestorPath {
    public static boolean  printPathToAncestor(BinaryTreeNode node,int data) {
        if (node == null) return false;
        if (node.getData() == data) {
            System.out.printf("-->" + node.getData());
            return true;
        }
        if (printPathToAncestor(node.getLeft(), data) || printPathToAncestor(node.getRight(), data)) {
            System.out.printf("-->" + node.getData());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTree mm = BinaryTreeCreatorHelper.getBinaryTreeExample2();
        PrintAncestorPath.printPathToAncestor(mm.root,2);
    }
}
