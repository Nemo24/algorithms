package datastructures.array;

/**
 * Created by mm on 15/1/16.
 */
public class MissingNumberInIncSequence {
    public int missingSequence(int[] arr) {
        if (arr.length == 0){
            System.out.println("nothing is missing");
            return -1;
        }
        return missingSequence(arr,0,arr.length-1);

    }
    private int missingSequence(int arr[],int leftOffset,int rightOffset) {
        if (leftOffset >= rightOffset) return leftOffset+1;
        int len = (leftOffset + rightOffset)/2;
        if (arr[len] < len + 1){
            //missing sequence is left side
           return missingSequence(arr,leftOffset,len);
        } else if (arr[len] > len + 1)
        {
            return missingSequence(arr,len,rightOffset);
        }
        else {
                return len +1;
            }
    }

    public static void main(String[] args) {
        int[] arr = {1,2, 4, 5, 6, 7};
        MissingNumberInIncSequence mm = new MissingNumberInIncSequence();
        System.out.println(""+ mm.missingSequence(arr));
    }
}
