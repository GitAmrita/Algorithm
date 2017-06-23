package StacksAndQueues;

import sun.misc.Sort;

import java.util.Stack;

/**
 * Created by amritachowdhury on 6/22/17.
 */
public class coding_3_5 {

    public class SortedStack extends Stack<Integer> {
        Stack<Integer> tempStack;

        public SortedStack() {
            tempStack = new Stack();
        }

        public void pushSortedStack(int data) {
            if (super.isEmpty()) {
                super.push(data);
            } else {
                if (super.peek() < data) {
                    sortStack(data);
                } else {
                    super.push(data);
                }
            }
        }

        public int popSortedStack() {
            if (super.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return super.pop();
        }

        private void sortStack(int data) {
            while (!super.isEmpty() && super.peek() < data) {
                tempStack.push(super.pop());
            }
            super.push(data);
            while (!tempStack.isEmpty()) {
                super.push(tempStack.pop());
            }
        }
    }

    public void run() {
        int popped = 0;
        SortedStack s = new SortedStack();

        s.pushSortedStack(100);
        s.pushSortedStack(50);
        s.pushSortedStack(200);

        popped = s.popSortedStack();
        System.out.println(popped);

        popped = s.popSortedStack();
        System.out.println(popped);

        popped = s.popSortedStack();
        System.out.println(popped);
    }
}
