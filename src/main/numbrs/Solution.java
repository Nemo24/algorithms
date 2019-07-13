import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

  /*
   * Complete the 'budgetShopping' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY bundleQuantities
   *  3. INTEGER_ARRAY bundleCosts
   */

  public static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {



    int numItems = bundleQuantities.size();
    int[][] matrix = new int[numItems + 1][n + 1];
    int[][] matrix2 = new int[numItems + 1][n + 1];

    for (int i = 0; i <= n; i++)
      matrix[0][i] = 0;

    for (int i = 1; i <= numItems; i++) {
      for (int j = 0; j <= n; j++) {
        if (bundleCosts.get(i - 1) > j) {
          matrix[i][j] = matrix[i - 1][j];
          matrix2[i][j] = matrix2[i -1][j];
        }
        else {
          matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - bundleCosts.get(i - 1)] +
              bundleQuantities.get(i - 1));
          matrix2[i][j] = matrix2[i -1][j] +bundleQuantities.get(i -1);
        }
      }
    }

    return matrix[numItems][n];
  }



}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/tmp/test.txt"));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    int bundleQuantitiesCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> bundleQuantities = IntStream.range(0, bundleQuantitiesCount).mapToObj(i -> {
      try {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    int bundleCostsCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> bundleCosts = IntStream.range(0, bundleCostsCount).mapToObj(i -> {
      try {
        return bufferedReader.readLine().replaceAll("\\s+$", "");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.budgetShopping(n, bundleQuantities, bundleCosts);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}