package SortingAndSearching;

import java.util.Arrays;

/**
 * Created by amritachowdhury on 6/27/17.
 */
public class coding_10_5 {

    public void run() {
        String [] input = populateArray();
        int targetIndex = binarySearch(0, input.length - 1, "ball", input);
        System.out.println(targetIndex);
    }

    private int binarySearch(int start, int end, String target, String[] input) {
        while (start <= end) {
            int mid = ( start + end ) / 2;
            if (input[mid].isEmpty()) {
                while (true) {
                    int left = mid - 1;
                    int right = mid + 1;
                    if (!input[left].isEmpty() && left >= start) {
                        mid = left;
                        break;
                    } else if (!input[right].isEmpty() && right <= end) {
                        mid = right;
                        break;
                    } else if (left < start && right > end) {
                        return -1;
                    } else {
                        left --;
                        right ++;
                    }
                }
            }
            int middle = input[mid].compareTo(target);
           if (middle == 0) {
               return mid;
           } else if (middle > 0) {
               end = mid - 1;
           } else {
               start = mid + 1;
           }
        }
        return -1;
    }

    private String[] populateArray() {
        String[] input = new String[13];
        Arrays.fill(input, "");
        input[0] = "at"; input[4] = "ball"; input[7] = "car"; input[10] = "dad";
        return input;
    }
}
