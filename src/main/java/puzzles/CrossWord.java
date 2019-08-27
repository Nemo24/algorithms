package puzzles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CrossWord {
  int rowLength,colLength;

  char[][] startingMatrix;

  public CrossWord(char[][] startingMatrix) {
    this.startingMatrix = startingMatrix;
    rowLength = startingMatrix.length;
    colLength = startingMatrix[0].length;
  }


  public char[][] result(List<String> words,char[][] matrix) throws Exception{
    boolean works = true;
    List<List<String>> permWords = permWords(words);
    for (List<String> wordList : permWords) {
      char[][] copyMatrix = copyMatrix(matrix);
      for(String word :wordList) {
        works = works && placeWord(word, copyMatrix);
      }
      if (works) return copyMatrix;
      works = true;
    }
    throw new Exception("No combination could be found") ;
  }

  private List<List<String>> permWords(List<String> words) {
    List<List<String>> perms = new ArrayList<>();
    List<String> accum = new ArrayList<>();
    permWords(perms,accum,words);
    return perms;
  }

  public void permWords(List<List<String>> perms,List<String> accum,List<String> words) {
    if (words.size() == 0) {
      perms.add(accum.stream().collect(Collectors.toList()));
      return ;
    }
    for (String word:words){
      accum.add(word);
      permWords(perms,accum,words.stream().filter(i -> !i.equals(word)).collect(Collectors.toList()));
      accum.remove(word);
    }

  }

  private boolean doesFitWord(String word,char[][] matrix,Pair pair) {
    int i = 0;
    int currentRow = pair.i;
    int currentCol = pair.j;
    //rowwise
    while (currentCol < colLength &&  i < word.length()
        && (matrix[currentRow][currentCol] =='-' || matrix[currentRow][currentCol] == word.charAt(i))
       ) {
      i++;
      currentCol++;

    }
    if (i == word.length() )  {
      i=0;
      currentRow = pair.i;
      currentCol = pair.j;
      while (currentCol < colLength) {
        matrix[currentRow][currentCol] = word.charAt(i);
        i++;
        currentCol++;
        if (i == word.length()) {
          break;
        }

      }
      return true;
    }
    i=0;
    currentRow = pair.i;
    currentCol = pair.j;
    //columnWise

    while (currentRow < rowLength
          &&  i < word.length() && (matrix[currentRow][currentCol] == '-'
            || matrix[currentRow][currentCol]== word.charAt(i)) ) {
      i++;
      currentRow++;

    }
    if (i == word.length()) {
      i=0;
      currentRow = pair.i;
      currentCol = pair.j;
      while (currentRow < rowLength) {
        matrix[currentRow][currentCol]= word.charAt(i);
        i++;
        currentRow++;
        if (i == word.length()) {
          break;
        }
      }
      return true;
    }
    return false;


  }

  private boolean placeWord(String word,char[][] matrix) {
    Set<Pair> visitedPairs = new HashSet<>();
    Pair pair = findNextStartingPoint(matrix,word,visitedPairs);

    boolean fits =false;
    while (pair != null && !fits) {
      fits  = doesFitWord(word,matrix,pair);
      pair = findNextStartingPoint(matrix,word,visitedPairs);
    }
    return fits;
  }


  private Pair findNextStartingPoint(char[][] matrix,String word,Set<Pair> visited) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j]=='-') {
          Pair pair = new Pair(i,j);
          if (!visited.contains(pair)){
            visited.add(pair);
            return pair;
          }
        }
        if (matrix[i][j] == word.charAt(0)) {
          Pair pair = new Pair(i,j);
          if (!visited.contains(pair)){
            visited.add(pair);
            return pair;
          }
        }
      }
    }
    return null;
  }


  private char[][] copyMatrix(char[][] from ) {
    char[][] to = new char[from.length][from[0].length];
    for (int i = 0; i < from.length; i++) {
      for (int j = 0; j < from[i].length; j++) {
        to[i][j] = from[i][j];
      }

    }
    return to;
  }
  public static void main(String[] args) throws Exception{
    CrossWordHelper crossWordHelper = new CrossWordHelper("/Users/manoharm/mm-personal/learning/algorithms/src/main/resources/crosswordinput/small/in/input3.txt",10);
    char[][] matrix = crossWordHelper.matrix;
    List<String> wordList = crossWordHelper.words;

    printMat(matrix);
    CrossWord crossWord = new CrossWord(matrix);
    char[][] result = crossWord.result(wordList,matrix);
    printMat(result);
  }

  public static void printMat(char[][] mat) {
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println();
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        char chars = mat[i][j];
        System.out.printf(" " + chars + " ");
      }
      System.out.println("");


    }
  }
}

class Pair {
  int i , j;

  public Pair(int i, int j) {
    this.i = i;
    this.j = j;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pair pair = (Pair) o;
    return i == pair.i &&
        j == pair.j;
  }

  @Override
  public int hashCode() {
    return Objects.hash(i, j);
  }
}