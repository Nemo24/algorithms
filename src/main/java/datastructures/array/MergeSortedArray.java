package datastructures.array;

public class MergeSortedArray {
    int[] arr1;
    int[] arr2;
    int[] mergedArray;
    public MergeSortedArray(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        mergedArray = new int[arr1.length+arr2.length];
    }
    public void merge(){
        int i = 0;
        int j = 0;
        int mergeInd = 0;
        while((i < arr1.length) && (j < arr2.length)){
            if (arr1[i] < arr2[j]) {
                mergedArray[mergeInd] = arr1[i];
                mergeInd++;
                i++;
            } else {
                mergedArray[mergeInd] = arr2[j];
                mergeInd++;
                j++;
            }
        }
       while (i < arr1.length){
           mergedArray[mergeInd] = arr1[i];
           mergeInd++;
           i++;
       }
        while (j < arr2.length){
            mergedArray[mergeInd] = arr2[j];
            mergeInd++;
            j++;
        }
    }


    public static void main(String[] args) {
        int[] array1 = {2,5,7,9};
        int[] array2 = {1,3,4,6,8,99};
        MergeSortedArray mm = new MergeSortedArray(array1,array2);
        mm.merge();
        for (int i = 0; i < mm.mergedArray.length; i++) {
            System.out.printf(mm.mergedArray[i]+"-->");

        }
    }
}
