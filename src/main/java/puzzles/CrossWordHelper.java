package puzzles;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CrossWordHelper {
    char[][] matrix  = null;
    List<String> words ;

  public CrossWordHelper(String fileName,int n) throws Exception {
    matrix = new char[n][n];
    List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    for (int i = 0; i < n; i++) {
      String line = lines.get(i);
      for (int j = 0; j < line.length(); j++) {
        matrix[i][j] = line.charAt(j);
      }

    }
    String wordsLine = lines.get(n);
    words = Arrays.asList(wordsLine.split(";"));
  }

  public char[][] getMatrix() {
    return matrix;
  }

  public List<String> getWords() {
    return words;
  }
}
