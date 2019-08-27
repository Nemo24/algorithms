package datastructures.array;

import java.util.Arrays;
import java.util.Collections;

public class CountTripletsSumLess {
    public static void main(String[] args) {
        int arr[] = {5,3,1,44,2,0};
        int sum = 4;
        Arrays.sort(arr);
        System.out.println("sorted array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
        int ans = 0;
        for (int i = 0; i < arr.length -2 ; i++) {
            int j = i+1;
            int k = arr.length -1 ;
            while ( j < k) {
                if (arr[i] + arr[j] + arr[k] > sum) k--;
                else {
                    System.out.println("i="+i+" j="+j+" k="+k);
                    ans = ans + (k - j);
                    j++;
                }

            }

        }
        System.out.println("answer = " + ans);

    }
}
