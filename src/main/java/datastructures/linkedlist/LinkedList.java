package datastructures.linkedlist;

/**
 * Created by mm on 15/10/15.
 */
public class LinkedList<T> {
  class Node {
      T data;
      Node next;

      public Node(T data) {
          this.data = data;
      }
  }
  Node head;

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("");
        Node tmp = head;
        while (tmp!=null){
            b.append(tmp.data.toString()+"-->");
            tmp=tmp.next;
        }
        return b.toString();
    }

    public void insert(T data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node tmp = new Node(data);
            tmp.next = head;
            head = tmp;
        }
    }
    public void reverse (){
        Node tmp=head,nextNode = head.next ;
        Node intm=null;
        head.next=null;
        while (tmp!=null && nextNode!=null){
            intm = nextNode.next;
           nextNode.next = tmp;
           tmp=nextNode;
            if (intm!=null) nextNode=intm; else break;

        }
        head=nextNode;
    }
    private Node reverseRecur(Node t) {
        if (t == null) return  null;
        else t.next = reverseRecur(t.next);
        return t;
    }
    public void reverseRecur() {
        head  = reverseRecur(head.next);

    }


    public void reverseList() {
        if(head==null || head.next == null)
            return ;

        Node p1 = head;
        Node p2 = head.next;

        head.next = null;
        while(p1!= null && p2!= null){
            Node t = p2.next;
            p2.next = p1;
            p1 = p2;
            if (t!=null){
                p2 = t;
            }else{
                break;
            }
        }

        head= p2;
    }


    public static void main(String[] args) {
        LinkedList<Integer> mm = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            mm.insert(i);

        }
        System.out.println(mm);
        mm.reverseRecur();
        System.out.println(mm);
    }

}

