package educative.cyclicsort;

public class FindDuplicate {

  public static int findNumber(int[] nums) {
    int i = 0 ;
    while ( i < nums.length ) {
      int j = nums[i] - 1;

      if (j < nums.length && nums[i]!=nums[j]) {
        swap(nums,i,j);
      } else {
        i++;
      }

    }

    for (int j = 0; j < nums.length; j++) {
      if (nums[j] !=j+1) return j + 1;

    }
    return -1;
  }
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  public static void main(String[] args) {
    System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
    System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
    System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));
  }
}