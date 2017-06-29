package SortingAndSearching;

/**
 * Created by amritachowdhury on 6/26/17.
 */
public class coding_10_3 {

    int array[] = new int[5];

    public void run() {
        populateArray();
        int index = findIndex(0, 4, 5);
        System.out.print(index);
    }

    private int findIndex(int start, int end, int target) {
        int mid = ( start + end )/ 2;
        if (array[mid] == target) {
            return mid;
        }
        boolean leftOrdered = isLeftHalfOrdered(0, mid);
        int selection = selectHalf(leftOrdered, start, mid, target);
        if (selection == 0) {
            return findIndex(start, mid, target);
        } else {
            return findIndex(mid + 1, end, target);
        }
    }

    private void populateArray() {
        array[0] = 50; array[1] = 5; array[2] = 20; array[3] = 30; array[4] = 40;
    }

    private boolean isLeftHalfOrdered(int start, int end) {
        return array[start] < array[end];
    }

    private int selectHalf(boolean isLeftOrdered, int start, int mid, int target) {
        if (isLeftOrdered) {
            int i = array[start] < target ? 0 : 1; // 0 - left half, 1 - right half
            return i;
        } else {
            int i = array[mid] < target ? 1 : 0;
            return i;

        }
    }
}
