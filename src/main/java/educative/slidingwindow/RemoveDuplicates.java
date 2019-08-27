package educative.slidingwindow;

class RemoveDuplicates {

  public static int remove(int[] arr) {
    int nextNonDuplicate = 1; // index of the next non-duplicate element
    for (int i = 1; i < arr.length; i++) {
      if (arr[nextNonDuplicate - 1] != arr[i]) {
        arr[nextNonDuplicate] = arr[i];
        nextNonDuplicate++;
      }
    }

    return nextNonDuplicate;
  }

  public static void printArr(int [] arr) {
    System.out.println();
    System.out.print('[');
    for (int i = 0 ; i < arr.length; i++) {
      System.out.print(","+ arr[i]);
    }
    System.out.println(']');

  }

  public static void main(String[] args) {
    int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
    printArr(arr);
    System.out.println(RemoveDuplicates.remove(arr));
    printArr(arr);

    arr = new int[] { 2, 2, 2, 11 };
    printArr(arr);
   // System.out.println(RemoveDuplicates.remove(arr));
    printArr(arr);

  }
}
