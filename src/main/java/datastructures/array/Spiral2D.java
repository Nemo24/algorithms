package datastructures.array;

/**
 * Created by mm on 1/3/16.
 */
public class Spiral2D {
    int[][] arr ;
    int row,col;

    public Spiral2D(int[][] arr) {
        this.arr = arr;

    }

    public  void printArray(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(String.format("%02d",arr[i][j]) + "   ");

            }
            System.out.println();
        }
    }
    public  void spiralPrint(){
        int xSize = arr.length;
        int ySize = arr[0].length;
        int i,  k = 0, l = 0;
        xSize--;  ySize--;

        while(k <= xSize && l <= ySize){
            for(i = l; i <= ySize; ++i) {
                System.out.print(arr[k][i]+ " ");
            }
            k++;

            for(i = k; i <= xSize; ++i) {
                System.out.print(arr[i][ySize] + " ");
            }
            ySize--;

            for(i = ySize; i >= l; --i) {
                System.out.print(arr[xSize][i] + " ");
            }
            xSize--;


            for(i = xSize; i >= k; --i) {
                System.out.print(arr[i][l] + " ");
            }
            l++;
        }
    }
    public   void printSpiral(){
           if ((arr ==null)||(arr.length==0)) return;
           int row = arr.length;
           int col = arr[0].length;
           System.out.println("row"+row+"col"+col);
            int k = 0;
            int l = 0;
            for (int i = 0; i < col; i++) {
                System.out.printf((String.format("%02d",arr[k][i]) + "   "));
            }
            k++;
            for (int i = k; i < row; i++) {
            System.out.printf((String.format("%02d",arr[i][col -1]) + "   "));
            }
            for (int i = col -1 -k; i >= 0; i--) {
            System.out.printf((String.format("%02d",arr[row-k][i]) + "   "));
            }
            //for (int i = row-1; i > 0; i++) {
            //System.out.printf((String.format("%02d",arr[row-1][0]) + "   "));
            //}

    }



    public static void main(String[] args) {
        int count =1;
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = count;
                count++;

            }
        }
        Spiral2D mm = new Spiral2D(arr);
        mm.printArray();
        mm.spiralPrint();
    }
}
