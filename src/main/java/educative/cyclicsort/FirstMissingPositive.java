package educative.cyclicsort;

public class FirstMissingPositive {
  public static int findNumber(int[] nums) {
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
        return i + 1;

    return nums.length;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  public static void main(String[] args) {
    System.out.println(FirstMissingPositive.findNumber(new int[] { -3, 1, 5, 4, 2 }));
    System.out.println(FirstMissingPositive.findNumber(new int[] { 3, -2, 0, 1, 2 }));
    System.out.println(FirstMissingPositive.findNumber(new int[] { 3, 2, 5, 1 }));
  }
}
