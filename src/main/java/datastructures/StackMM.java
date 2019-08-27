package datastructures;

import java.util.Random;

/**
 * Created by mm on 10/1/16.
 */
public class StackMM {

    int[] internalArr;
    int maxSize;
    int top = -1;

    int[] minArray;
    int minArrayIndex = -1;

    public StackMM(int maxSize) {
        this.maxSize = maxSize;
        this.internalArr = new int[maxSize];
        this.minArray = new int[maxSize];
    }

    public int pop() throws Exception {
        if (isEmpty()) throw new Exception("cannot pop empty stack");
        int elem=  internalArr[top--];
        if (elem == minArray[minArrayIndex]) --minArrayIndex;
        return elem;
        }

    public int min() {
        if (!isEmpty()) return minArray[minArrayIndex];
        else return -111111111;
    }

    public boolean isEmpty() {
        return top ==-1;
    }
    public int peek() throws Exception {
        if (isEmpty()) throw new Exception("cannot pop empty stack");
        return internalArr[top - 1 ];    }

    public void push(int elem) throws Exception{
        if (top == (maxSize -1 )) throw  new Exception("stack is full");
        internalArr[++top] = elem;
        if (minArrayIndex == -1) {
            minArray[++minArrayIndex]=elem;
        }
        else if (elem < minArray[minArrayIndex]) {
            minArray[++minArrayIndex]=elem;
        }

    }


    public static void main(String[] args) throws Exception {
        Random rand = new Random();

        int size = 10;
        StackMM stackMM = new StackMM(size);
        for (int i = 0; i < size; i++) {
            int x = rand.nextInt(100);
            System.out.println("x is " + x);
            stackMM.push(x);
        }

        System.out.println("===================================");
        System.out.println("popping " + stackMM.pop());
        System.out.println("popping " +stackMM.pop());
        System.out.println("min  " +stackMM.min());
        stackMM.push(-9999);
        System.out.println("min" +stackMM.min());
        System.out.println("popping " + stackMM.pop());
        System.out.println("min " +stackMM.min());


    }

}
