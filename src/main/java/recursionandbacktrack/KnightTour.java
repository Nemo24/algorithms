package recursionandbacktrack;

public class KnightTour {
    int[][] board ;
    int size;
    int[] rowPathmm = {1 ,1 ,-1, -1 , 2,-2, 2 , -2};
    int[] colPathmm = {2,-2, 2 , -2 ,1 ,1 ,-1, -1};
   int rowPath[] = {2, 1, -1, -2, -2, -1, 1, 2};
  int colPath[] = {-1, 2, 2, 1, -1, -2, -2, 1};
  public KnightTour(int size) {
    board = new int[size][size];
    this.size = size;
  }

  public void print() {
    for (int i = 0; i < rowPathmm.length; i++) {
      System.out.println(rowPathmm[i]+":"+colPathmm[i]);

    }
    System.out.println("deee");
    for (int i = 0; i < rowPath.length; i++) {
      System.out.println(rowPath[i]+":"+colPath[i]);

    }
  }

  public boolean isTourPossible(int row, int col) {
    board[row][col] = 1;
    return isTourPossible( row,col, 1);
  }

  private boolean isTourPossible(int row , int col,int depth) {
    if (depth == size*size) {
      return true;

    }
    for (int i = 0; i < rowPath.length; i++) {
        int newRow = row+rowPath[i];
        int newCol = col+colPath[i];
        if (isValidMove(newRow, newCol)) {

          board[newRow][newCol] = depth;
          if (isTourPossible(newRow, newCol, depth + 1)) {
            return true;
          } else {
            board[newRow][newCol] = 0;
          }
        }
      }
    return false;
  }

  private  boolean isValidMove(int row,int col) {
    boolean isValid = row >= 0 && row < size;
    isValid = isValid && col >= 0 && col < size;
    isValid = isValid && board[row][col] == 0;
    return isValid;
  }

  private void  printBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j]+"    ");

      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    KnightTour mm = new KnightTour(8);
    //mm.print();
    if (mm.isTourPossible(0,0)) {
      mm.printBoard();
    } else {
      System.out.println("not possible");
    }
  }
}
