package recursionandbacktrack;

public class NQueens {
    Board board;
    int size;
  public NQueens(int size) {
    this.size = size;
    board = new Board(size);
  }

  public void findPath() {
    findPath(0);
    board.printBoard();
  }

  private boolean findPath(int col) {
    if (col == size ) return true;
    for (int i = 0; i < size; i++) {
       if (board.isSafe(i,col)) {
         board.placeQueen(i,col);
         if (findPath(col+1)) {
           return true ;
         }
         board.removeQueen(i,col);
       }

    }
    return false;
  }

  public static void main(String[] args) {
    NQueens nQueens = new NQueens(5);
    nQueens.findPath();
  }
}

class Board {
  int size ;
  int[][] board;
  public Board(int size) {
    this.size = size;
    board = new int[size][size];
  }

  public boolean isSafe(int row, int col){
    for (int i = 0; i < board.length; i++) {
      if (board[row][i] == 1) return false;
    }
    int i = row,j = col;
    while ( i >=0 && j >=0) {
      if (board[i--][j--] == 1) return false;
    }
    i = row;
    j=col;
    while (i<size && j>=0) {
      if (board[i++][j--] == 1) return false;
    }
    return true;
  }

  public void placeQueen(int row,int col) {
    board[row][col] = 1;
  }

  public void removeQueen(int row,int col) {
    board[row][col] = 0;
  }

  public void printBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 0) {
          System.out.print(" - ");
        } else {
          System.out.print(" Q ");
        }
      }
      System.out.println();
    }
  }


}