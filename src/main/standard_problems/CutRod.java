public class CutRod {

  int[] lengths;
  int[] value;

  int[] benefitMaxTable;

  public CutRod(int[] length, int[] value) {
    this.lengths = length;
    this.value = value;
    benefitMaxTable = new int[lengths.length];
  }

  public int optimalCutRod(){
    benefitMaxTable[0] = value[0];
    for (int i = 1; i < lengths.length; i++) {
      benefitMaxTable[i] =max(i);
    }
    return benefitMaxTable[lengths.length-1];
  }

  private int max(int i){
    int max = Integer.MIN_VALUE;
    for (int k = 1; k < i; k++) {
      max  = Math.max(max,value[k]+benefitMaxTable[i -k-1]);
    }
    max = Math.max(max,value[i]);
    return max;
  }

  public static void main(String[] args) {
    int[] lengths = {1,2,3,4,5,6,7,8};
    int[] value = {1,5,8,9,10,17,17,20};
    CutRod cutRod = new CutRod(lengths,value);
    System.out.println(cutRod.optimalCutRod() +"");
    System.out.println();
  }

}
