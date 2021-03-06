package educative.cyclicsort;
import java.util.*;

public class FirstKMissingPositive {

  public static List<Integer> findNumbers(int[] nums, int k) {
    List<Integer> missingNumbers = new ArrayList<>();
    int i = 0;
    while (i < nums.length) {
      if (nums[i] <= nums.length && nums[i] >0 && nums[i] != nums[nums[i] -1])
        swap(nums, i, nums[i] -1);
      else
        i++;
    }

    // find the first number missing from its index, that will be our required number
    for (i = 0; i < nums.length; i++)
      if (nums[i] != i +1 )
        missingNumbers.add( i + 1);

    return missingNumbers;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
    System.out.println("Missing numbers: " + missingNumbers);

    missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
    System.out.println("Missing numbers: " + missingNumbers);

    missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2);
    System.out.println("Missing numbers: " + missingNumbers);
  }
}