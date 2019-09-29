package leetcode.MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;
import leetcode.ListNode;

public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val,o2.val);
      }
    });

    for (ListNode l :lists) {
      while ( l!=null) {
        minHeap.offer(l);
        l= l.next;
      }
    }

    ListNode dummy = new ListNode(-999);
    ListNode l = dummy;
    while (!minHeap.isEmpty()) {
      l.next = minHeap.poll();
    }
    return dummy.next;
  }

  private ListNode mergeTwoLists(ListNode l1 , ListNode l2) {
    ListNode dummy = new ListNode(-999);
    ListNode l = dummy;

    while(l1 != null && l2!=null) {
      if (l1.val < l2.val) {
        l.next = l1;
        l1 = l1.next;

      } else {
        l.next = l2;
        l2 = l2.next;
      }
      l = l.next;
    }
    l.next = l1 == null ?l2 : l1;

    return dummy.next;
  }
}