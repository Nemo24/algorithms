package educative.intervals;
import java.util.*;


/***
 * Example 1:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 * Example 2:
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
 * Output: [[1,3], [4,12]]
 * Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
 * Example 3:
 *
 * Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
 * Output: [[1,4], [5,7]]
 * Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].
 * ​
 */

public class InsertInterval {

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if ((intervals == null) || intervals.isEmpty()) {
      return Arrays.asList(newInterval);
    }
    int i = 0;
    List<Interval> mergedIntervals = new ArrayList<>();
    // newInterval is larger and does not overlap
    while ( i < intervals.size() && intervals.get(i).end < newInterval.start) {
      mergedIntervals.add(intervals.get(i));
      i++;
    }

    //newInterval overlaps
    while ( i < intervals.size() && intervals.get(i).start < newInterval.end) {
      newInterval.start = Math.min(intervals.get(i).start,newInterval.start);
      newInterval.end = Math.max(intervals.get(i).end,newInterval.end);
      i++;
    }

    // add the interval from above
    mergedIntervals.add(newInterval);

    // add rest of intervals

    while ( i < intervals.size()) {
      mergedIntervals.add(intervals.get(i));
      i++;
    }
    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(2, 3));
    input.add(new Interval(5, 7));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}
