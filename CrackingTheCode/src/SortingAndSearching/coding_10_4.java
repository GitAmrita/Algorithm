package SortingAndSearching;

import java.util.ArrayList;

/**
 * Created by amritachowdhury on 6/26/17.
 */
public class coding_10_4 {

    ArrayList<Integer> listy = new ArrayList<>();
    int someStartNo = 22; int target = 2;

    public void run() {
        populateListy();
        int index = getIndex();
        if (index == Integer.MIN_VALUE) {
            System.out.print(" Number not found");
        } else {
            System.out.print(" Number found at " + index);
        }
    }

    private int getIndex() {
        int no;
        int idx = getIndex(someStartNo);
        int thisNo = elementAt(idx);
        if (target < thisNo) {
            no = searchNo(0, thisNo);
        } else {
            no = linearSearch(thisNo);
        }
        return no;
    }

    private int linearSearch(int start) {
        for (int i = start; i <= 2 * start; i++) {
            int thisNo = elementAt(i);
            if (thisNo == target) {
                return i;
            }
            if (thisNo == -1) {
                break;
            }
        }
        return Integer.MIN_VALUE;
    }

    private int getIndex(int i) {
        if (elementAt(i) == -1) {
            i = i / 2;
            if (i == 0) {return 0;}
            return getIndex(i);
        } else {
            return i;
        }
    }

    private int searchNo(int start, int end) {
        while (start < end) {
            int mid = ( start + end ) / 2;
            int middleElement = elementAt(mid);
            if (middleElement == target) {
                return mid;
            }
            if (middleElement < target) {
                return searchNo(mid + 1, end);
            } else {
                return searchNo(start, mid - 1);
            }
        }
        return Integer.MIN_VALUE;
    }

    private void populateListy() {
        listy.add(1);  listy.add(3); listy.add(4); listy.add(5); listy.add(5); listy.add(5);
        listy.add(6); listy.add(7); listy.add(8); listy.add(9);
    }

    private int elementAt(int position) {
        try {
            return listy.get(position);
        } catch (Exception e) {
            return -1;
        }
    }
}
