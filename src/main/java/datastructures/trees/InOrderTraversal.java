package datastructures.trees;

import datastructures.StackMM;

import java.util.Stack;

public class InOrderTraversal {
    public void inorderRecur(BinaryTree tree){
        if (tree==null) return;
        inorderRecur(tree.root);
    }
    private void inorderRecur(BinaryTreeNode node){
        if (node ==null) return;
        inorderRecur(node.getLeft());
        System.out.printf(node.getData() +"-->");
        inorderRecur(node.getRight());

    }
    public void inorderIter(BinaryTree tree){
        if (tree==null) return;
        if (tree.root==null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode temp=tree.root;
        while (true) {
                while(temp!=null){
                    stack.push(temp);
                    temp=temp.getLeft();
                }
            if (stack.isEmpty()) break;
            temp = stack.pop();
            System.out.printf(temp.getData()+"-->");
            temp = temp.getRight();

        }
    }

    public static void main(String[] args) {
        BinaryTree tree = BinaryTreeCreatorHelper.getBinaryTreeExample();
        InOrderTraversal traversal = new InOrderTraversal();
        traversal.inorderRecur(tree);
        System.out.println();
        traversal.inorderIter(tree);

    }
}
