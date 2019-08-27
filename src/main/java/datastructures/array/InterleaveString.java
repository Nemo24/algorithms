package datastructures.array;

public class InterleaveString {
    public static void main(String[] args) {
        char[] result = new char[6];
        interleave("abc","def",result,3,3,0);
    }
    public static void interleave(String input1, String input2, char temp[],int m, int n, int i) {
        if (m == 0 && n == 0) {
            System.out.println(temp);
        }
        if (m != 0) {
            temp[i] = input1.charAt(0);
            interleave(input1.substring(1), input2, temp, m - 1, n, i + 1);
        }
        if (n != 0) {
            temp[i] = input2.charAt(0);
            interleave(input1, input2.substring(1), temp, m, n - 1, i + 1);
        }
    }
}
