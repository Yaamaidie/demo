package leetcode.easy;

import java.util.Arrays;

public class Problem155 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(1);
        obj.push(10);
        obj.push(8);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}

class MinStack {
    public static final int DEFUALT_SIZE = 10;
    private int[] theArray;
    private int topOfStack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        theArray = new int[10];
        topOfStack = 0;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        topOfStack++;
        if (topOfStack > theArray.length - 1) {
            theArray = Arrays.copyOf(theArray, 2 * theArray.length);
        }
        if (x < min) {
            theArray[topOfStack] = min;
            min = x;
            topOfStack++;
            if (topOfStack > theArray.length - 1) {
                theArray = Arrays.copyOf(theArray, 2 * theArray.length);
            }
        }
        theArray[topOfStack] = x;
    }

    public void pop() {
        if (theArray[topOfStack--] == min) {
            min = theArray[topOfStack--];
        }
    }

    public int top() {
        return theArray[topOfStack];
    }

    public int getMin() {
        return min;
    }
}