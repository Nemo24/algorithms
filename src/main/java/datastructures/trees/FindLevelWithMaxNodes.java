package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mm on 15/1/16.
 */
public class FindLevelWithMaxNodes {
    public int findLevel(BinaryTree tree) {
        return findMaxLevel(tree.root);
    }



    private int findMaxLevel(BinaryTreeNode root) {
        if (root == null) return  0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int maxLevel = 1;
        int maxNumber = 1;
        int level = 1;
        int levelNumber = 0;
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            if (node == null) {
                level++;
                if (levelNumber > maxNumber) {
                    maxLevel = level;
                    maxNumber = levelNumber;
                }
                levelNumber = 0;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }

            } else {
                if (node.getLeft()!=null){
                    queue.add(node.getLeft());
                    levelNumber++;
                }
                if (node.getRight()!=null){
                    queue.add(node.getRight());
                    levelNumber++;
                }
            }


        }
        System.out.println("maxlevel is " + maxLevel + " maxNumber is "+ maxNumber);
        return maxNumber;
    }

    public static void main(String[] args) {
        FindLevelWithMaxNodes mm = new FindLevelWithMaxNodes();
        BinaryTree tree = BinaryTreeCreatorHelper.getBinaryTreeExample();
        int level = mm.findLevel(tree);
        System.out.println("level = " + level);

        System.out.println("==================");
        System.out.println("==================");
        System.out.println("==================");
        System.out.println("==================");
        System.out.println("==================");

        BinaryTree tree2 = BinaryTreeCreatorHelper.getBinaryTreeExample2();
        int level2 = mm.findLevel(tree2);
        System.out.println("level = " + level2);

        System.out.println("==================");
        System.out.println("==================");
        System.out.println("==================");
        System.out.println("==================");
        System.out.println("==================");

        BinaryTree tree3 = BinaryTreeCreatorHelper.getBinaryTreeExample3();
        int level3 = mm.findLevel(tree3);
        System.out.println("level = " + level3);
    }

}
