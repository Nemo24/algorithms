package leetcode.meetingrooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  public int minMeetingRooms(int[][] intervals) {
    List<Interval> intervalList = new ArrayList();
    for(int i = 0; i< intervals.length ; i++) {
      Interval inv = new Interval(intervals[i][0],intervals[i][1]);
      intervalList.add(inv);
    }
    Collections.sort(intervalList, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
      }
    });

    int minRooms = 0;
    PriorityQueue<Interval> minHeap = new PriorityQueue<>(new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.end - o2.end;
      }
    });

    for( Interval interval : intervalList) {
      while (!minHeap.isEmpty() && interval.start >= minHeap.peek().end) {
        minHeap.poll();
      }
      minHeap.add(interval);
      minRooms = Math.max(minRooms,minHeap.size());
    }

    return minRooms;
}
}

class Interval{
  int start ,end;
  public Interval(int s, int e) {
    Map<Integer,Integer> ss = new HashMap<>();
    PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue(new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        return ((Map.Entry<Integer,Integer>) o1).getValue() - ((Map.Entry<Integer,Integer>) o2).getValue();
      }
    });
    start = s;
    end = e;
  }
}