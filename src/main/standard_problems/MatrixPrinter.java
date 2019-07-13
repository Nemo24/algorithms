public class MatrixPrinter {

  public static <T extends Object> void printMatrix( T[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.printf(""+matrix[i][j].toString()+"  ");
      }
      System.out.println();
    }
  }
}
