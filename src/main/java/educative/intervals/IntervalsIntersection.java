package educative.intervals;

import java.util.*;

/***
 * Example 1:
 *
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 * Example 2:
 *
 * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
 * Output: [5, 7], [9, 10]
 * Explanation: The output list contains the common intervals between the two lists.
 */
public class IntervalsIntersection {

  public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
    List<Interval> intervalsIntersection = new ArrayList<Interval>();
    int arr1Index = 0,arr2Index = 0;
    while (arr1Index < arr1.length && arr2Index < arr2.length) {
      Interval int1 = arr1[arr1Index];
      Interval int2 = arr2[arr2Index];

      //does not overlap
      if (int1.end < int2.start) {
        intervalsIntersection.add(int1);
        arr1Index++;
        continue;
      }

      //does not overlap
      if (int2.end < int1.start) {
        intervalsIntersection.add(int2);
        arr2Index++;
        continue;
      }

      //overlaps
      int start = Math.min(int1.start,int2.start);
      int end = Math.max(int1.end,int2.end);
      intervalsIntersection.add(new Interval(start,end));
      arr1Index++;
      arr2Index++;

    }
    return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
  }

  public static void main(String[] args) {
    Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
    Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
    Interval[] result = IntervalsIntersection.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
    input2 = new Interval[] { new Interval(5, 10) };
    result = IntervalsIntersection.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
  }
}
