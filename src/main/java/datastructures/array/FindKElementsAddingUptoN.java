package datastructures.array;

public class FindKElementsAddingUptoN {
    int[] arr ;
    int k;
    int N;
    int count;
    public FindKElementsAddingUptoN(int[] arr,int k, int N) {
        this.arr = arr;
        this.k = k;
        this.N = N;
    }

    public void sum(){
        for (int i = 0; i < arr.length; i++) {
            sum(i,arr.length,0);
        }
    }
    private void sum(int start,int end,int currSum){
        if ((start >= end )||(start<0)||(end > arr.length)) return;
        if (currSum>N) return;
        if (currSum == N) {
            System.out.println("in loop start"+start+" end"+ end+ " currSum"+currSum);

            count++;
            return;
        }
        sum(start+1,end,currSum+arr[start]);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        FindKElementsAddingUptoN mm = new FindKElementsAddingUptoN(arr,-1,6);
        mm.sum();
        System.out.printf("count"+mm.count);
    }

}
