package educative.intervals;

import java.util.*;
/***
 * Example 1:
 *
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].
 *
 * Example 2:
 *
 * Intervals: [[6,7], [2,4], [5,9]]
 * Output: [[2,4], [5,9]]
 * Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
 * ​
 * Example 3:
 *
 * Intervals: [[1,4], [2,6], [3,5]]
 * Output: [[1,6]]
 * Explanation: Since all the given intervals overlap, we merged them into one.
 */
public class MergeIntervals {
  public static List<Interval> merge(List<Interval> intervals) {
  List<Interval> mergedIntervals = new LinkedList<Interval>();
  intervals.sort(new Comparator<Interval>() {
    @Override
    public int compare(Interval o1, Interval o2) {
     return Integer.compare(o1.start,o2.start);
    }
  });

  mergedIntervals.add(intervals.get(0));
  intervals.remove(0);
  while (intervals.size() >0) {
    Interval interval = intervals.remove(0);
    Interval mergedInt = mergedIntervals.get(mergedIntervals.size()-1);
    if (overlaps(mergedInt,interval)) {
      mergedIntervals.remove(mergedInt);
      mergedIntervals.add(merge(mergedInt,interval));
    } else {
      mergedIntervals.add(interval);
    }
  }
  return mergedIntervals;
}

private static boolean overlaps(Interval sortedInterval1 , Interval sortedInterval2) {
    return sortedInterval2.start <= sortedInterval1.end;
}

private static Interval merge(Interval sortedInterval1,Interval sortedInterval2) {
    Interval interval = new Interval(sortedInterval1.start,Math.max(sortedInterval1.end,sortedInterval2.end));
    return interval;
}

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 5));
    input.add(new Interval(7, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(6, 7));
    input.add(new Interval(2, 4));
    input.add(new Interval(5, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 6));
    input.add(new Interval(3, 5));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}

enum Boundary {
  START,END;
}
