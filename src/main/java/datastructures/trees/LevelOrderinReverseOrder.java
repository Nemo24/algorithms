package datastructures.trees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mm on 16/1/16.
 */
public class LevelOrderinReverseOrder {
    /***
     *                1
     *           2         3
     *       4      5    6     7
     *
     *  output shud be 4567231
     */

    public void printReverse(BinaryTree tree) {
       printReverse(tree.root);
    }

    private void printReverse(BinaryTreeNode root) {
        if (root ==null) return;
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.remove();
            stack.push(node);
            if (node.getRight()!=null) queue.add(node.getRight());
            if (node.getLeft()!=null) queue.add(node.getLeft());
        }
       while (!stack.empty()){
           BinaryTreeNode node = stack.pop();
           System.out.printf("node " + node.getData()+ "--->");
       }
    }

    public static void main(String[] args) {
        LevelOrderinReverseOrder mm  = new LevelOrderinReverseOrder();
        BinaryTree tree = BinaryTreeCreatorHelper.getBinaryTreeExample();
        mm.printReverse(tree);
    }
}
