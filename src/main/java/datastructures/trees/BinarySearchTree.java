package datastructures.trees;

/**
 * Created by mm on 29/8/15.
 */
public class BinarySearchTree<Key extends Comparable<Key> , Value > {
        Node root;
        class Node {
                private Key key;           // sorted by key
                private Value val;         // associated data
                private Node left, right;  // left and right subtrees
                private int N;             // number of nodes in subtree

                public Node(Key key, Value val) {
                        this.key = key;
                        this.val = val;
                }
        }
       public  Value get(Key k){
               Node n = root;
               while (n != null){
                       int equality= n.key.compareTo(k);
                       if (equality < 0) n=n.left;
                       else if (equality > 0) n=n.right;
                       else if (equality == 0) return n.val;
               }
               return null;
       }
        public void put(Key k , Value val){
            root = put(root,k,val);

        }
        private Node put(Node x,Key k , Value val){
                if (x == null) return new Node(k,val);
                if (x.key.compareTo(k) < 0) x.left = put(x.left,k,val);
                else if (x.key.compareTo(k) > 0) x.right = put(x.right,k,val);
                else if (x.key.compareTo(k) == 0) x.val = val;
                return x;
        }

        public Key min(){
                if (root==null) return null;
                else return min(root);
        }
        public Key min(Node x){
            if (x.left ==null) return x.key;
            else return min(x.left);
        }
        public Key floor(Key k){
            Node x = floor(root,k);
            if (x ==null) return null;
            return x.key;
        }
        public Node floor(Node x, Key k){
            int cmp = x.key.compareTo(k);
            if (cmp ==0) return x;
            if (cmp <0) return floor(x.left,k);
            Node t  = floor(x.right,k);
            if (t!=null) return t ;else return x;
        }
        public Key ceil(Key k){
            Node x = ceil(root,k);
            if (x ==null) return null;
            return x.key;
        }
        public Node ceil(Node x, Key k){
            int cmp = x.key.compareTo(k);
            if (cmp ==0) return x;
            if (cmp >0) return ceil(x.right,k);
            Node t  = ceil(x.left,k);
            if (t!=null) return t ;else return x;
        }

}
