package SortingAndSearching;

/**
 * Created by amritachowdhury on 6/26/17.
 */
public class coding_10_1 {

    int[] a = new int[7];
    int[] b = new int[5];

    public void run() {
        populateArray();
        mergeSorted();
        System.out.println(java.util.Arrays.toString(a));
    }

    private void mergeSorted() {
        int pointerA = 0; int pointerB = 0;
        while (pointerB < b.length) {
            if (a[pointerA] < b[pointerB] && a[pointerA] != Integer.MIN_VALUE) {
                pointerA ++;
            } else {
                shiftElements(pointerA);
                a[pointerA] = b[pointerB];
                pointerA ++;
                pointerB ++;
            }
        }
    }

    private void populateArray() {
        a[0] = 2; a[1] = 3; a[2] = Integer.MIN_VALUE; a[3] = Integer.MIN_VALUE; a[4] = Integer.MIN_VALUE; a[5] = Integer.MIN_VALUE;
        a[6] = Integer.MIN_VALUE;

        b[0] = 5; b[1] = 20; b[2] = 60; b[3] = 98; b[4] = 100;
    }

    private void shiftElements(int start) {
        for (int i = a.length - 1; i >= start; i--) {
            if (a[i] == Integer.MIN_VALUE) {
                continue;
            }
            a[i + 1] = a[i];
        }
    }
}
