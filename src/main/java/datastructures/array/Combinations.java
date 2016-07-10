package datastructures.array;

import java.util.Arrays;

public class Combinations {
    String str ;
    boolean[] arrTracking;

    public Combinations(String str) {
        this.str = str;
        arrTracking = new boolean[str.length()];
    }
    public void combo(){
        combinationAnother(1,str.length());
    }

    public static void main(String[] args){
        String[] arr = {"A","B","C","D","E","F"};
        String s = "ABCD";
        Combinations mm  = new Combinations(s);
        mm.combo();
       // combinations2(arr, 3, 0, new String[3]);
    }

    static void combinations2(String[] arr, int len, int startPosition, String[] result){
        if (len == 0){
            System.out.println(Arrays.toString(result));
            return;
        }
        System.out.println(Arrays.toString(result));

        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }

     void combinationAnother(int k , int N){
        if (k == N){
            arrTracking[k-1]=false;
            print();
            arrTracking[k-1]=true;
            print();
            return;
        }
         System.out.println();

         arrTracking[k]=false; combinationAnother(k+1,N);
        arrTracking[k]=true; combinationAnother(k+1,N);
    }
     void print( ){
        for (int i = 0; i < arrTracking.length; i++) {
            if (arrTracking[i]){
                System.out.printf(str.charAt(i)+"");
            }
        }

    }
}