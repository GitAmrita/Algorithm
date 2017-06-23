package StacksAndQueues;

import java.util.Stack;

/**
 * Created by amritachowdhury on 6/22/17.
 */
public class coding_3_3 {

    public class StackOfPlates {
        Stack<Stack<Integer>> platesStack;
        private final int THRESHOLD = 3;

        public StackOfPlates() {
            platesStack = new Stack<>();
        }

        public void addPlates(int plateNo) {
            if (platesStack.isEmpty()) {
                createNewStack(plateNo);
            } else {
                Stack<Integer> temp = platesStack.peek();
                if (temp.size() < THRESHOLD) {
                    Stack<Integer> currentStack = platesStack.pop();
                    currentStack.push(plateNo);
                    platesStack.push(currentStack);
                } else {
                    createNewStack(plateNo);
                }
            }
            System.out.println("Plate added : " + plateNo + " stackSize : " + getStackPlateSize());
        }

        public int getPlates() {
            if (platesStack.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            Stack<Integer> currentStack = platesStack.pop();
            int poppedVal = currentStack.pop();
            if (!currentStack.isEmpty()) {
                platesStack.push(currentStack);
            }
            System.out.println("Plate taken : " + poppedVal + " stackSize : " + getStackPlateSize());
            return poppedVal;
        }

        public int getPlateAt(int zeroBasedIndex) {
            // you are asking for a value that isn't even present in the stack
            int poppedVal = Integer.MIN_VALUE ;
            if (zeroBasedIndex >= platesStack.size() * THRESHOLD) {
                return poppedVal;
            }

            Stack<Integer> tempSubStackAfterIndex = storeValuesAfterIndex(zeroBasedIndex);
            Stack<Integer> tempSubStackAtIndex = new Stack<>();
            poppedVal = storeValuesAtIndex(zeroBasedIndex, tempSubStackAtIndex);

            while (!tempSubStackAtIndex.empty()) {
                addPlates(tempSubStackAtIndex .pop());
            }

            while (!tempSubStackAfterIndex.empty()) {
                addPlates(tempSubStackAfterIndex.pop());
            }
            return poppedVal;
        }

        private Stack<Integer> storeValuesAfterIndex(int zeroBasedIndex ) {
            int stackNo = zeroBasedIndex / THRESHOLD;
            Stack<Integer> tempStack, tempSubStackAfterIndex = new Stack<>();
            for (int i = platesStack.size() - 1; i > stackNo; i--) {
                tempStack = platesStack.pop();
                for (int j = 0; j < THRESHOLD; j++) {
                    if (tempStack.empty()) {
                        break;
                    }
                    tempSubStackAfterIndex.push(tempStack.pop());
                }
            }
            return tempSubStackAfterIndex;
        }

        private int storeValuesAtIndex(int zeroBasedIndex, Stack<Integer> tempSubStackAtIndex) {
            Stack<Integer> tempStack;
            int poppedVal = Integer.MIN_VALUE;
            tempStack = platesStack.pop();
            int subStackNo = zeroBasedIndex % THRESHOLD;
            for (int j = THRESHOLD - 1; j >= 0; j--) {
                if (tempStack.empty()) {
                    break;
                }
                if (j == subStackNo) {
                    poppedVal = tempStack.pop();
                    continue;
                }
                tempSubStackAtIndex.push(tempStack.pop()) ;
            }
            return poppedVal;
        }

        private int getStackPlateSize() {
            return platesStack.size();
        }

        private void createNewStack(int plateNo) {
            Stack<Integer> subStack = new Stack();
            subStack.push(plateNo);
            platesStack.push(subStack);
        }
    }

    public void run() {
        StackOfPlates s = new StackOfPlates();
        s.addPlates(100); s.addPlates(71); s.addPlates(62); s.addPlates(4); s.addPlates(7);
      //  s.getPlates();
      //  s.getPlates();
      //  s.getPlates();
        s.addPlates(15); s.addPlates(1); s.addPlates(6); s.addPlates(8); s.addPlates(10);
      //  s.getPlates();
      //  s.addPlates(3); s.addPlates(5);
        int size = s.getStackPlateSize();
        System.out.println(size);
        int popped = s.getPlateAt(5);
        System.out.println(popped);
        size = s.getStackPlateSize();
        System.out.println(size);

    }
}
