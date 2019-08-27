package datastructures.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public class MinSumPartion {
    int[] arr ;
    List<Integer> part1 ;
    List<Integer> part2 ;
    int leftSum = 0;
    int rightSum = 0;
    boolean [] used;
    public MinSumPartion(int[] arr) {
        this.arr = arr;
        used = new boolean[arr.length];
        part1 = new ArrayList<>();
        part2 = new ArrayList<>();
    }
    private int findNearestNeighbour(int i ){
        int index = -1;
        int diff = Integer.MAX_VALUE;
        for (int j = 0; j < arr.length; j++) {
            if (j == i) continue;
            if (used[j]) continue;
            if (Math.abs(arr[j] - arr[i]) < diff) {
                diff = Math.abs(arr[j] - arr[i]);
                index =j;
            }
        }
        return index;
    }
    public void partionMinSumCorrect(){
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            int j = findNearestNeighbour(i);
            if (leftSum < rightSum){
                leftSum = leftSum+ Math.max(arr[i],arr[j]);
                part1.add( Math.max(arr[i],arr[j]));
                rightSum = rightSum+ Math.min(arr[i],arr[j]);
                part2.add(Math.min(arr[i],arr[j]));
            } else {
                leftSum = leftSum+ Math.min(arr[i],arr[j]);
                part1.add( Math.min(arr[i],arr[j]));
                rightSum = rightSum+ Math.max(arr[i],arr[j]);
                part2.add(Math.max(arr[i],arr[j]));
            }
            used[i] = true;
            used[j] = true;
        }
    }
    public void partionMinSum(){

        int i = 0;
        while (i +1 < arr.length){
            int one = arr[i];
            int two = arr[i+1];
            if (leftSum > rightSum) {
                if ( one > two) {
                    rightSum+=one;
                    leftSum+=two;
                    part1.add(two);
                    part2.add(one);
                } else {
                    rightSum+=two;
                    leftSum+=one;
                    part1.add(one);
                    part2.add(two);
                }
            } else {
                if ( one > two) {
                    rightSum+=two;
                    leftSum+=one;
                    part1.add(one);
                    part2.add(two);

                } else {
                    rightSum+=one;
                    leftSum+=two;
                    part1.add(two);
                    part2.add(one);
                }
            }
            i=i+2;
        }

    }

    public static void main(String[] args) {
       // int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] arr = {10,2,6,3,7,8,4,1,5,9};
        MinSumPartion mm = new MinSumPartion(arr);
        mm.partionMinSumCorrect();
        System.out.println(mm.leftSum +":" + mm.rightSum);
        System.out.println("left");
        for(int i : mm.part1){
            System.out.printf(i+"->");
        }
        System.out.println("right");
        for(int i : mm.part2){
            System.out.printf(i+"->");
        }
    }
}
