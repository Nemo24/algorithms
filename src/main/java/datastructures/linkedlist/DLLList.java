package datastructures.linkedlist;

/**
 * Created by mm on 10/1/16.
 */
public class DLLList {
    DLLNode head ;

    public DLLList() {
    }

    public void addNode(DLLNode node) {
        if (node ==null) return;
        if (head ==null) head = node;
        else {
            head.next = node;
            node.prev = head;
            head = node;
        }
    }

    public void print(){
        DLLNode temp = head;
        System.out.println("printing from right to left");
        while (temp!=null) {
            System.out.printf(temp.data + "<-------");
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        DLLList dllList = new DLLList();
        int size = 7;
        for (int i = 1; i <=7; i++) {
        dllList.addNode(new DLLNode(i));
        }
        dllList.print();
        }

}
