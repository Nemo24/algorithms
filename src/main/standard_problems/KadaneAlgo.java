/***
 * Kadanes algorithm is used to find max sum of subarray
 * Kadanes algorithm assumes there is atleast one positive element in the array
 */
public class KadaneAlgo {

  public static int sum(int[] arr) {
    int ans = 0;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (sum + arr[i] > 0) {
        sum = sum + arr[i];
      } else {
        sum = 0;
      }
      ans = Math.max(sum,ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {1,-3,2,-5,7,6,-1,-4,11,-23};
    int sum = KadaneAlgo.sum(arr);
    System.out.println("sum is "+ sum);
  }
}
