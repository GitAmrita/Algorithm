package FiveStarPhoneInterview;

import java.util.PriorityQueue;

/**
 * Created by amritachowdhury on 6/6/17.
 */
public class MedianQuestion {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();//lower half
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();//higher half

    
    public void testCasePostAPI() {
        /* if we pretend input1, input2, input3 are the list of numbers sent via 3 POST requests, we can find out the
         median at any time.
         input1 -> 5, 6, 3, 2, 8, 9, 11 Median calculated on the list {5, 6, 3, 2, 8, 9, 11} is 6
         input2 -> 7, 4, 1, 10  Median calculated on the list {5, 6, 3, 2, 8, 9, 11, 7, 4, 1, 10} is 5.5
         input3 -> 5, 6, 3, 2, 8, 9, 11, 13, 10, 12 Median calculated on the list {5, 6, 3, 2, 8, 9, 11, 7, 4, 1,
         13, 10, 12} is 7

         This way for any number of POST request made to the server, we can get the median whenever we want.
          This is just the algorithm part.
        */
        int[] input1 = new int[] {5, 6, 3, 2, 8, 9, 11};
        processRequestPOST(input1);

        float median = getMedian();
        System.out.println("Median: " + median);

        int[] input2 = new int[] {7, 4, 1};
        processRequestPOST(input2);

        median = getMedian();
        System.out.println("Median: " + median);

        int[] input3 = new int[] {13, 10, 12};
        processRequestPOST(input3);

        median = getMedian();
        System.out.println("Median: " + median);
    }

    private void processRequestPOST(int[] input) {
        for (int i = 0; i < input.length; i++) {
            putInHeap(input[i]);
        }
    }

    private void putInHeap(int number) {
        // first number ever insert into max heap.
        if (maxHeap.size() == minHeap.size() && maxHeap.size() == 0) {
            addNumberToMaxHeap(number);
        } else {
            // since the aim is to have the lower half of the stream of numbers on max Heap.
            if ( peekNumberFromMaxHeap() > number) {
                int no = getNumberFromMaxHeap();
                addNumberToMaxHeap(number);
                addNumberToMinHeap(no);
            } else {
                addNumberToMinHeap(number);
            } // balanced heap in this case means the difference in height between max heap and min heap should be no greater than 1
            if (!isBalanced()) {
                balanceHeap();
            }
        }
    }

    private float getMedian() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize  = minHeap.size();
        float median;
        if (maxHeapSize  == minHeapSize) {
            median = (peekNumberFromMaxHeap() + peekNumberFromMinHeap() ) * 1.0f / 2;
        } else if (maxHeapSize  > minHeapSize) {
            median = peekNumberFromMaxHeap();
        } else {
            median = peekNumberFromMinHeap();
        }
        return median;
    }

    private void balanceHeap() {
        if ( minHeap.size() >  maxHeap.size()) {
            addNumberToMaxHeap(getNumberFromMinHeap());
        } else {
            addNumberToMinHeap(getNumberFromMaxHeap());
        }
    }

    private boolean isBalanced() {
        int maxHeapSize = maxHeap.size();
        int minHeapSize  = minHeap.size();
        if (maxHeapSize  == minHeapSize) {
            return true;
        }
        int differenceInHeight = maxHeapSize - minHeapSize;
        if (Math.abs(differenceInHeight) > 1) {
            return false;
        } else {
            return true;
        }
    }

    // getter and setter methods

    private void addNumberToMaxHeap(int number) {
        maxHeap.add( -1 * number); // since there's no library implementation of maxheap. So I just negate the number while adding
    }

    private int getNumberFromMaxHeap() {
        return -1 * maxHeap.poll();
    }

    private int peekNumberFromMaxHeap() {
        return -1 * maxHeap.peek();
    }

    private void addNumberToMinHeap(int number) {
        minHeap.add(number);
    }

    private int getNumberFromMinHeap() {
        return minHeap.poll();
    }

    private int peekNumberFromMinHeap() {
        return minHeap.peek();
    }

}
