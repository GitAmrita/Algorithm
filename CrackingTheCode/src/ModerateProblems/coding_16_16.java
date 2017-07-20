package ModerateProblems;

/**
 * Created by amritachowdhury on 7/12/17.
 */
public class coding_16_16 {
    public void run() {
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7};
        int [] result = subSort(a);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private int[] subSort(int[] a) {
        int mid = a.length / 2;
        int beginSort = mid; int endSort = mid;
        int left = mid - 1; int right = mid + 1;
        while (left >= 0 && right < a.length) {
            if (a[left] >= a[mid]) {
                beginSort = left;
            }
            left --;
            if (a[right] <= a[mid]) {
                endSort = right;
            }
            right++;
        }
        return  new int [] {beginSort, endSort};
    }
}
