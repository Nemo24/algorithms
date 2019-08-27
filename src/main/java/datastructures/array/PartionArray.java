package datastructures.array;

public class PartionArray {
    int[] arr;
    int pivot;
    int pivotValue ;
    public PartionArray(int[] arr, int pivot) {
        this.arr = arr;
        this.pivot = pivot;
        pivotValue = arr[pivot];
    }


    public void partionArray(){
        int start = 0;
        int end = arr.length-1;

        while (start<end){
           while(arr[start] < pivotValue) start++;
            while(arr[end] > pivotValue) end--;
            if (start < end)swap(arr,start,end);
        }
       // swap(arr,start,pivot);
    }

    private static void swap (int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {65,70,75,80,60,55,45};
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+"->");
        }
        PartionArray mm = new PartionArray(arr,1);
        mm.partionArray();
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+"->");
        }
    }


}
