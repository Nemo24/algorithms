import java.util.Scanner;

/**
 * Created by mm on 22/6/15.
 */
 class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            for (int j = a-1; j < b; j++) {
                array[j]+=k;
                if (max< array[j]) {max = array[j];};
            }
        }
        System.out.println(max);
    }


}
