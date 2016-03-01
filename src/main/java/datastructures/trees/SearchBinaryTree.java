package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mm on 27/2/16.
 */
public class SearchBinaryTree {
    public static boolean searchBinaryTree(BinaryTree tree,int data) {
          if (tree ==null) return false;
          return   searchBinaryTree(tree.root,data);
    }
    
    private static Boolean searchBinaryTree(BinaryTreeNode root ,int data){
        if (root ==null) return false;
        if (root.getData() == data) return  true;
        Boolean ispresentleft = searchBinaryTree(root.getLeft(),data);
        if (ispresentleft) return true;
        return searchBinaryTree(root.getRight(),data);
  }
    public  static Boolean searchBinaryTreeWithoutRecursion(BinaryTree tree,int data){
        if (tree == null) return false;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(tree.root);
        while (!queue.isEmpty()){
            BinaryTreeNode temp = queue.remove();
            if (temp.getData()==data) return true;
            if (temp.getLeft()!=null) queue.add(temp.getLeft());
            if (temp.getRight()!=null) queue.add(temp.getRight());
        }
        return false;

    }

    public static void main(String[] args) {
        BinaryTree mm = BinaryTreeCreatorHelper.getBinaryTreeExample3();
        Boolean m1 = searchBinaryTree(mm,1);
        Boolean m2 = searchBinaryTree(mm,2);
        Boolean m3 = searchBinaryTree(mm,13);
        Boolean m4 = searchBinaryTree(mm,20);
        System.out.println("m1 = " + m1 + " m2=" +m2 +" m3="+m3 +" m4="+m4);
        Boolean am1 = searchBinaryTreeWithoutRecursion(mm,1);
        Boolean am2 = searchBinaryTreeWithoutRecursion(mm,2);
        Boolean am3 = searchBinaryTreeWithoutRecursion(mm,13);
        Boolean am4 = searchBinaryTreeWithoutRecursion(mm,20);
        System.out.println("m1 = " + am1 + " m2=" +am2 +" m3="+am3 +" m4="+am4);
    }
}
