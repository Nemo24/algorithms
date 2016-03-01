package datastructures.trees;

/**
 * Created by mm on 30/8/15.
 */
public class BinaryTree {
    final int SPACE = 4;
    BinaryTreeNode root;
    final int INITMID = 20;


    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }
    public void print(){
        for (int i = 0; i < INITMID; i++) {
            System.out.printf(" ");
        }
        print(1,root.getLeft(),true,INITMID);
        print(1,root.getRight(),false,INITMID);
    }
    private void print(int level,BinaryTreeNode n,boolean left ,int mid){
        for (int i = 0; i < level; i++) {
            System.out.println("");
        }
        int newmid;
        if (left) {
             newmid = mid - 2;
        } else  {
            newmid = mid + 2;
        }

        for (int i = 0; i < newmid; i++) {
            System.out.printf(" ");
        }
        if (n!=null) {
            System.out.printf(n.getData()+"");
            print(level  +1,n.getLeft(),true,newmid);
            print(level + 1,n.getRight(),false,newmid);

        }


    }

    public static void main(String[] args) {
        BinaryTree mm = BinaryTreeCreatorHelper.getBinaryTreeExample();
        mm.print();
    }
}
