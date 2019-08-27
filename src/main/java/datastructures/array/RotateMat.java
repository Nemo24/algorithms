package datastructures.array;

/**
 * Created by mm on 8/1/16.
 */
public class RotateMat {

    public static void printMat(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf(a[i][j] + "   ");
               }
            System.out.println("");
        }
    }
    public static void rotateMatAntiClock(int[][] a) {
        int n = a.length;
        for (int i=0; i<n/2; i++){
            int layerfirst = i ;
            int temp = a[layerfirst][layerfirst];
            int layerlast = n - i -1;
            for (int j = layerfirst; j < layerlast; j++) {
                a[layerfirst][j]=a[layerfirst][j+1];
            }
            for (int j = layerfirst; j < layerlast; j++) {
                a[j][layerlast]=a[j+1][layerlast];
            }
            for (int j = layerlast; j > layerfirst; j--) {
                a[layerlast][j]=a[layerlast][j-1];
            }
            for (int j = layerlast; j > layerfirst +1; j--) {
                a[j][layerfirst]=a[j-1][layerfirst];
            }
            a[layerfirst+1][layerfirst]=temp;

        }
    }
    public static void rotateMatClock(int[][] a) {
        int n = a.length;
        for (int i=0; i<n/2; i++){
            int layerfirst = i ;
            int temp = a[layerfirst][layerfirst];
            int layerlast = n - i -1;
            for (int j = layerfirst; j < layerlast; j++) {
                a[j][layerfirst]=a[j+1][layerfirst];
            }
            for (int j = layerfirst; j < layerlast; j++) {
                a[layerlast][j]=a[layerlast][j+1];
            }
            for (int j = layerlast; j > layerfirst; j--) {
                a[j][layerlast]=a[j-1][layerlast];
            }
            for (int j = layerlast; j > layerfirst +1; j--) {
                a[layerfirst][j]=a[layerfirst][j-1];
            }
            a[layerfirst][layerfirst+1]=temp;

        }
    }
    public static void main(String[] args) {
        int size = 4;
        int[][] arr = new int[size][size];
        int value = 10;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = value++;
            }

        }
        printMat(arr);
        //rotateMatAntiClock(arr);
        rotateMatClock(arr);
        System.out.println();
        System.out.println();
        printMat(arr);
      }
}
