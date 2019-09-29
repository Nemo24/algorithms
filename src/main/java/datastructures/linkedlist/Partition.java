package datastructures.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * partition a linked list given a data x
 * such that all < x are to left of x and all > x are to the right</>
 */
public class Partition {

  public static LinkedListNode partition( LinkedListNode node,int x) {
    LinkedListNode head = node;
    LinkedListNode tail = node;

    while (node != null) {
      LinkedListNode next = node.next;
      if (node.data <= x) {
        node.next = head;
        head = node;
      } else {
        tail.next = node;
        tail = node;
      }
      node = next;
    }
    tail.next = null;
    return head;
  }

  public static LinkedListNode partition2(LinkedListNode node, int x) {
    LinkedListNode beforeStart = null;
    LinkedListNode beforeEnd = null;
    LinkedListNode afterStart = null;
    LinkedListNode afterEnd = null;
    /*Partition list*/
    while (node != null) {
      LinkedListNode next = node.next;
      node.next = null;
      if (node.data < x) {
        /*Insert node into end of before list*/
        if (beforeStart == null) {
          beforeStart = node;
          beforeEnd = beforeStart;
        } else {
          beforeEnd.next = node;
          beforeEnd = node;
        }
      } else {
        /* Insert node into end of after list*/
        if (afterStart == null) {
          afterStart = node;
          afterEnd = afterStart;
        } else {
          afterEnd.next = node;
          afterEnd = node;
        }
      }
      node = next;
    }
    if (beforeStart == null) {
      return afterStart;
    }

    /* Merge before list and after list */
    beforeEnd.next = afterStart;
    List<Integer> s = new ArrayList<>();
    return beforeStart;
  }

  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(4);
    head.next = new LinkedListNode(7);
    head.next.next = new LinkedListNode(3);
    head.next.next.next = new LinkedListNode(8);
    head.next.next.next.next = new LinkedListNode(1);
    //LinkedListNode partition = partition(head, 5);
    LinkedListNode partition = partition2(head, 5);
    System.out.println(('8' -'0') * 9);
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> valueToIndexMap = new HashMap();
    for(int i = 0 ; i < nums.length;i++) {
      if (valueToIndexMap.containsKey(target - nums[i])) {
        int[] res= {valueToIndexMap.get(target - nums[i]),nums[i]};
        return res;
      }
      valueToIndexMap.put(nums[i],i);
    }
    int[] res =  {-1,-1};
    return res;
  }
}
