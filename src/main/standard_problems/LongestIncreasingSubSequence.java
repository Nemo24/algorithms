import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubSequence {
    int[] arr;
    int[] lisArr;
    List<List<Integer>> longestIncreasingList;


    int maxSubSequenceIndex = 0;

    public LongestIncreasingSubSequence(int[] arr) {
        this.arr = arr;
        lisArr = new int[arr.length];
        longestIncreasingList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            longestIncreasingList.add(new ArrayList<>());

        }
    }

    public int lis() {
        int maxLis = 1;
        for (int i = 0; i < arr.length; i++) {
            lisArr[i] = maxPreviousLis(i);
            if (maxLis <= lisArr[i]) {
                maxLis = lisArr[i];
                maxSubSequenceIndex =i;
            }

        }
        PrintHelper.printIntArr(lisArr);
        return maxLis;
    }

    private int maxPreviousLis(int i) {
        int max = 1;
        boolean foundIncreasing  = false;
        for (int j = 0; j < i; j++) {
           if ((arr[i] > arr[j]) && max <= lisArr[j]) {
               max = lisArr[j] + 1;
               List<Integer> lisAtThisPoint = new ArrayList<>();
               lisAtThisPoint.addAll(longestIncreasingList.get(j));
               lisAtThisPoint.add(arr[i]);
               foundIncreasing = true;
               longestIncreasingList.set(i,lisAtThisPoint) ;
           }

        }
        if (!foundIncreasing) {
            List<Integer> lisAtThisPoint = new ArrayList<>();
            lisAtThisPoint.add(arr[i]);
            longestIncreasingList.set(i,lisAtThisPoint);

        }
        return max;
    }



    public static void LIS(int[] arr){
        LongestIncreasingSubSequence instance = new LongestIncreasingSubSequence(arr);
        int longestIncreasingSub = instance.lis();

        System.out.println(String.format("Longest increasing subsequence for this arr %s is %s", Arrays.toString(arr),longestIncreasingSub));
        System.out.printf("the arr is ");
        System.out.println(instance.longestIncreasingList.get(instance.maxSubSequenceIndex));
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        int[] arr1 = {5,4,3,1,4,7,8,5,4,6,7,8};
        LongestIncreasingSubSequence.LIS(arr1);
        int[] arr2 = {2, 7 , 3 , 4 , 9 , 8 , 12};
        LongestIncreasingSubSequence.LIS(arr2);
    }


    
}