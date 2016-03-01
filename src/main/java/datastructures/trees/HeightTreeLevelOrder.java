package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mm on 27/2/16.
 */
public class HeightTreeLevelOrder {
    public static int height(BinaryTree tree) {
        if (tree == null) return 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(tree.root);
        queue.add(null);
        int height = 0;
        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.remove();
            if (temp == null) {
                if (!queue.isEmpty()) queue.add(null);
                height++;
            } else {
                if (temp.getLeft() != null) queue.add(temp.getLeft());
                if (temp.getRight() != null) queue.add(temp.getRight());

            }
        }
        return height;
    }

    public static void main(String[] args) {
        BinaryTree mm = BinaryTreeCreatorHelper.getOneSidedBinaryTreeExample();
        int height = height(mm);
        System.out.printf("height" + height);
    }
}

