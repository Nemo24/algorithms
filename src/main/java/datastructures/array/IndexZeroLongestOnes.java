package datastructures.array;

/**
 * Created by mm on 29/2/16.
 */
public class IndexZeroLongestOnes {
    int index=-1;
    int maxCount = 0;
    int[] arr ;

    public IndexZeroLongestOnes(int[] arr) {
        this.arr = arr;
    }

    public  void bruteforce() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                int currentCount = getCount(i);
                if (currentCount > maxCount){
                    maxCount =currentCount;
                    index = i;
                }
            }

        }
    }
    private int getCount(int index){
        int i = index-1;
        int count = 0;
        while (i>=0 && arr[i]==1){
            count=count+arr[i];
            i--;
        }
        i=index+1;
        while ( i<arr.length && arr[i]==1){
            count=count+arr[i];
            i++;
        }
        return count+1;
    }
    public void dynamic(){
        int prev_prev_zero = -1;
        int prev_zero=-1;
        int maxCount = 0;
        int index = 0;

        for(int i=0; i<arr.length; i++){
            if (arr[i]==0){
                if ((i-prev_prev_zero) > maxCount) {
                    index = prev_zero;
                    maxCount = i-prev_prev_zero -1;
                }
                prev_prev_zero =prev_zero;
                prev_zero = i;

            }
        }
        if (arr.length-prev_prev_zero > maxCount){
            maxCount = arr.length-1-prev_prev_zero;
            index = prev_zero;
        }

        System.out.println("index:"+index +":count:"+maxCount);


    }
    public void geekssol(){
            int n = arr.length;
            int max_count = 0;  // for maximum number of 1 around a zero
            int max_index=0;  // for storing result
            int prev_zero = -1;  // index of previous zero
            int prev_prev_zero = -1; // index of previous to previous zero

            // Traverse the input array
            for (int curr=0; curr<n; ++curr)
            {
                // If current element is 0, then calculate the difference
                // between curr and prev_prev_zero
                if (arr[curr] == 0)
                {
                    // Update result if count of 1s around prev_zero is more
                    if (curr - prev_prev_zero > max_count)
                    {
                        max_count = curr - prev_prev_zero -1;
                        max_index = prev_zero;
                    }

                    // Update for next iteration
                    prev_prev_zero = prev_zero;
                    prev_zero = curr;
                }
            }

            // Check for the last encountered zero
            if (n-prev_prev_zero > max_count) {
                max_index = prev_zero;
                max_count= n-prev_prev_zero-1;

            }
        System.out.println("index:"+max_index +":count:"+max_count);


    }


    public static void main(String[] args) {
       // int[] arr = {1 ,0 ,1, 1, 0, 1,1, 0, 1, 1, 1, 0, 1,1,1};
        int[] arr = {1  ,1, 1};

        IndexZeroLongestOnes mm  = new IndexZeroLongestOnes(arr);
        mm.bruteforce();
        System.out.println("index:"+mm.index +":count:"+mm.maxCount);
        mm.dynamic();
        mm.geekssol();

    }
}
