public class Knapsack {
  int[] weight;
  int[] value;
  int maxCapacity;
  int[][] dpTable;

  public Knapsack(int[] weight, int[] value, int maxCapacity) {
    this.weight = weight;
    this.value = value;
    this.maxCapacity = maxCapacity;
    dpTable = new int[weight.length+1][maxCapacity+1];
  }

  public int getMaxValueGeeksSol(){
    dpTable = new int[weight.length+1][maxCapacity+1];

    int n = weight.length;
    int W = maxCapacity;
    // Build table K[][] in bottom up manner
    for (int i = 0; i <= n; i++)
    {
      for (int w = 0; w <= W; w++)
      {
        if (i==0 || w==0)
          dpTable[i][w] = 0;
        else if (weight[i-1] <= w)
          dpTable[i][w] = Math.max(value[i-1] + dpTable[i-1][w-weight[i-1]],  dpTable[i-1][w]);
        else
          dpTable[i][w] = dpTable[i-1][w];
      }
    }

    return dpTable[n][W];
  }

  public int getMaxValue() {
    for (int i = 0; i < weight.length; i++) {
      dpTable[i][0] = 0;
    }
    for (int i = 0; i < maxCapacity; i++) {
      dpTable[0][i] = 0;

    }
    for (int i = 1; i <= weight.length; i++) {
      for (int j = 1; j <= maxCapacity; j++) {
        if (weight[i -1] > j) {  // weight of i'th item is greater than J we cannot pick i'th item
          dpTable[i][j] = dpTable[i -1][j];
        } else { // we can choose to pick or not pick i'th item depending on whether we get better value
          dpTable[i][j] = Math.max(dpTable[i -1][j],value[i-1] + dpTable[i - 1][j - weight[i-1]]);
        }                                           //value of i'th item          //subtract weight of i'th item

      }
    }
    return dpTable[weight.length][maxCapacity];
  }

  public static void main(String[] args) {
    int[] weight = {2,3,4,5};
    int[] value = {3,4,5,6};
    int maxCapacity = 6;
    Knapsack knapsack = new Knapsack(weight,value,maxCapacity);
    //int max = knapsack.getMaxValueGeeksSol();
    int max = knapsack.getMaxValue();
    System.out.println("Max value = " +max);

    PrintHelper.printIntMatrix(knapsack.dpTable);
  }
}
