package datastructures.trees;


import datastructures.linkedlist.DLLList;
import datastructures.linkedlist.DLLNode;

/**
 * Created by mm on 10/1/16.
 */
public class BinaryTreetoDLL {

    public DLLList convertBinaryTreetoDLL(BinaryTree binaryTree) {
        DLLList dllList = new DLLList();
        convertBinaryTreetoDLL(binaryTree.root,dllList);
        return dllList;
    }

    private void convertBinaryTreetoDLL(BinaryTreeNode node,DLLList dll) {
        if (node == null) return ;
        if (node.getLeft()!=null) convertBinaryTreetoDLL(node.getLeft(),dll);
        dll.addNode(new DLLNode(node.getData()));
        if (node.getRight()!=null) convertBinaryTreetoDLL(node.getRight(),dll);

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTreeCreatorHelper.getBinaryTreeExample();
        BinaryTreetoDLL binaryTreetoDLL = new BinaryTreetoDLL();
        DLLList dllList = binaryTreetoDLL.convertBinaryTreetoDLL(binaryTree);
        dllList.print();
        System.out.printf("done");
    }
}
