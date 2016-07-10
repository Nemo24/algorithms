package datastructures.array;

public class DutchNationalFlagPartitioning {
    public static void main(String[] args) {
        int[] arr = {2,1,0,1,2,0,0,1,2,2,1,1};
        System.out.println("initial arr");
        print(arr);
        int low = 0;
        int mid = 0;
        int hi = arr.length-1;
        while (mid <= hi) {
            switch (arr[mid]){
                case 0 :
                    swap(arr,low,mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr,mid,hi);
                    hi--;
                    break;
            }
        }
        System.out.println("final arr");
        print(arr);
    }

    private static void swap (int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }
        System.out.println();
    }
}
