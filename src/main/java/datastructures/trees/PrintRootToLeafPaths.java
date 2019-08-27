package datastructures.trees;

/**
 * Created by mm on 27/2/16.
 */
public class PrintRootToLeafPaths {
    int[] path = new int[256];

    public void printRootToLeafPaths(BinaryTree tree){
        if (tree ==null) return;
        printRootToLeafPaths(tree.root,path,0);
    }
    private void printRootToLeafPaths(BinaryTreeNode node,int[] path,int pathLen){
        if (node ==null) return;
        path[pathLen]=node.getData();
        pathLen++;
        if ((node.getLeft()==null) &&(node.getRight()==null)){
            printArray(path,pathLen);
        }
        if (node.getLeft()!=null) printRootToLeafPaths(node.getLeft(),path,pathLen);
        if (node.getRight()!=null) printRootToLeafPaths(node.getRight(),path,pathLen);
    }
    private void printArray(int[] path,int pathLen){
        for (int i = 0; i < pathLen; i++) {
            System.out.printf("->"+path[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        PrintRootToLeafPaths mm = new PrintRootToLeafPaths();
        BinaryTree tree = BinaryTreeCreatorHelper.getBinaryTreeExample3();
        mm.printRootToLeafPaths(tree);
    }
}
