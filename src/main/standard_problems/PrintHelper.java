public class PrintHelper {

  public static  void printIntMatrix( int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.printf(""+matrix[i][j]+"  ");
      }
      System.out.println();
    }
  }

  public static void printIntArr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.printf(""+arr[i]+"  ");

    }
  }
}
