package Recursion;

/**
 * Created by amritachowdhury on 4/29/17.
 */
public class coding_8_3_approach_2 {
    int a[];

    public void isMagicNoPresent() {
        fillArray();
        boolean isFound = checkMagicNoWithoutDistinct(0, a.length - 1);
        System.out.print(isFound);
    }

    private boolean checkMagicNoWithoutDistinct(int lower, int upper) {
        int mid = ( lower + upper) / 2;
        while (lower <= upper) {
            if (a[mid] == mid) {
                return true;
            } else {
                 checkMagicNoWithoutDistinct(lower, a[mid]);
                 checkMagicNoWithoutDistinct(mid + 1, upper);
            }
        }
        return false;
    }

    private boolean checkMagicNoWithDistinct(int lower, int upper) {
        int mid = ( lower + upper ) / 2;
        while (lower <= upper) {
            if (a[mid] == mid) {
                return true;
            } else if (a[mid] < mid) {
                return checkMagicNoWithDistinct(mid + 1, upper);
            } else {
                return checkMagicNoWithDistinct(lower, mid - 1);
            }
        }
        return false;
    }

    private void fillArray() {
       // a = new int[] { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
        a = new int[] { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
    }
}
