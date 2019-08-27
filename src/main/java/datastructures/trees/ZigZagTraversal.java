package datastructures.trees;

import java.util.Stack;

/**
 * Created by mm on 28/2/16.
 */
public class ZigZagTraversal {
    Stack<BinaryTreeNode> currentLevel = new Stack<>();
    Stack<BinaryTreeNode> nextLevel = new Stack<>();
    boolean leftToRight = true;

    public void traverse(BinaryTreeNode root){
        if (root == null) return;
        currentLevel.push(root);
        BinaryTreeNode temp;

        while(!currentLevel.isEmpty()){
            temp = currentLevel.pop();
            if (temp!=null) System.out.printf("-->"+temp.getData());
            if (leftToRight){
                if (temp.getLeft()!=null) nextLevel.push(temp.getLeft());
                if (temp.getRight()!=null) nextLevel.push(temp.getRight());
            } else {
                if (temp.getRight()!=null) nextLevel.push(temp.getRight());
                if (temp.getLeft()!=null) nextLevel.push(temp.getLeft());
            }
            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<BinaryTreeNode> tempStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempStack;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree mm = BinaryTreeCreatorHelper.getBinaryTreeExample2();
        ZigZagTraversal zig = new ZigZagTraversal();
        zig.traverse(mm.root);
    }
}
