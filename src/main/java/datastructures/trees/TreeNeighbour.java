package datastructures.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by mm on 15/1/16.
 */
public class TreeNeighbour{
    HashMap<BinaryTreeNode,BinaryTreeNode> nodeNeighBourMap ;
    public void findNeighBoursIterative(BinaryTree tree) {
        nodeNeighBourMap = new HashMap<>();
        findNeighBoursLevelTraversalMethod(tree.root);
        printNeighbours();
    }

    public void findNeighBoursRecursive(BinaryTree tree){
        if (tree.root==null) return;
        nodeNeighBourMap = new HashMap<>();
        findNeighboursRecursive(tree.root,tree.root.getLeft());
        findNeighboursRecursive(tree.root,tree.root.getRight());
        printNeighbours();
    }


    private void findNeighboursRecursive(BinaryTreeNode parent,BinaryTreeNode child){

        if (child!=null){
            if (parent.getLeft()==child) {
                nodeNeighBourMap.put(child, parent.getRight());
            } else {
                if (nodeNeighBourMap.get(parent)!=null){
                    nodeNeighBourMap.put(child,nodeNeighBourMap.get(parent).getLeft());
                }
            }
            findNeighboursRecursive(child,child.getLeft());
            findNeighboursRecursive(child,child.getRight());
        }

    }


    private void findNeighBoursLevelTraversalMethod(BinaryTreeNode root) {
        if (root ==null) return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode neighbour = null;
        queue.add(null);
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.remove();
            BinaryTreeNode prevNode = queue.peek();
            if (node!=null) nodeNeighBourMap.put(node,prevNode);
            if (node!=null) {
            if (node.getLeft()!=null){
                queue.add(node.getLeft());
                System.out.printf("node"+node.getLeft().getData()+ "--->");
            }
            if (node.getRight()!=null){
                queue.add(node.getRight());
                System.out.printf("node" + node.getRight().getData() + "--->");
            }}
            else if (!queue.isEmpty()) {
                System.out.printf("null-->");
                queue.add(null);
            };
        }

    }

    private void printNeighbours() {
        System.out.println();
        for (Map.Entry<BinaryTreeNode, BinaryTreeNode> entry : nodeNeighBourMap.entrySet()){
            System.out.printf("node " + entry.getKey().getData());
            if (entry.getValue()!=null) System.out.printf(" neighbour " + entry.getValue().getData());
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        TreeNeighbour mm = new TreeNeighbour();
        BinaryTree tree = BinaryTreeCreatorHelper.getBinaryTreeExample();
        mm.findNeighBoursIterative(tree);

        BinaryTree tree2 = BinaryTreeCreatorHelper.getBinaryTreeExampleUneven();
        mm.findNeighBoursIterative(tree2);
        System.out.println("");
        System.out.println("recursive");
        System.out.println("");
        System.out.println("");
        mm.findNeighBoursRecursive(tree);
        mm.findNeighBoursRecursive(tree2);
    }

}

