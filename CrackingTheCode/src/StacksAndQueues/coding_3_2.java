package StacksAndQueues;

import java.util.Stack;

/**
 * Created by amritachowdhury on 6/22/17.
 */
public class coding_3_2 {

    public class StackWithMin extends Stack<Integer> {
        Stack<Integer> minStack;

        public StackWithMin() {
            minStack = new Stack<>();
        }

        public Integer getMinimum() {
            if (minStack.isEmpty()) {
                return null;
            } else {
                return minStack.peek();
            }
        }

        public void push(int data) {
            super.push(data);
            if (minStack.empty()) {
                minStack.push(data);
                return;
            }
            int currentMin = minStack.peek();
            if (data < currentMin) {
                minStack.push(data);
            }
        }

        public Integer popVal() {
            if (super.empty()) {
                return null;
            }
            int poppedVal = super.pop();
            if (poppedVal == minStack.peek()) {
                minStack.pop();
            }
            return poppedVal;
        }
    }

    public void run() {
        int min;
        StackWithMin s = new StackWithMin();
        s.push(5);
        min = s.getMinimum();
        System.out.println("min is : " + min);
        s.push(6);
        min = s.getMinimum();
        System.out.println("min is : " + min);
        s.push(3);
        min = s.getMinimum();
        System.out.println("min is : " + min);
        s.push(7);
        min = s.getMinimum();
        System.out.println("min is : " + min);
        s.popVal();
        min = s.getMinimum();
        System.out.println("min is : " + min);
        s.popVal();
        min = s.getMinimum();
        System.out.println("min is : " + min);

    }
}
