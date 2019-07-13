public class EditDistance {
    String s1;
    String s2;

    int[][] matrix =null;
  public EditDistance(String s1, String s2) {
    this.s1 = s1;
    this.s2 = s2;
    matrix = new int[s1.length()+1][s2.length()+1];
  }

  public int getDistance() {
    populateDP();
    PrintHelper.printIntMatrix(matrix);
    return matrix[s1.length()][s2.length()];
  }

  private void populateDP(){
    matrix = new int[s1.length()+1][s2.length()+1];
    for (int i = 0; i <= s2.length(); i++) {
      matrix[0][i] = i;
    }
    for (int i = 0; i <= s1.length(); i++) {
      matrix[i][0] = i;
    }
    for (int i = 1; i <=s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
          matrix[i][j] = matrix[i-1][j-1];
        } else {
          matrix[i][j] = 1 + min(matrix[i-1][j],matrix[i][j-1],matrix[i-1][j-1]);
        }

      }

    }
  }

  private int min(int a , int b , int c) {
    return Math.min(Math.min(a,b),c);
  }

  public static void editDistance(String s1 ,String s2) {
    EditDistance ed = new EditDistance(s1,s2);
    int distance = ed.getDistance();
    System.out.println(String.format("distance between %s and %s = %d",s1,s2,distance));
    System.out.println("------------------------------");
  }

  public static void main(String[] args) {
    EditDistance.editDistance("hello","halo");
    EditDistance.editDistance("benyam","ephrem");
    EditDistance.editDistance("abc","ac");
    EditDistance.editDistance("abcdef","azced");
    EditDistance.editDistance("blyte","bytel");
  }
}
