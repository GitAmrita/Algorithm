package SortingAndSearching;

import java.util.Arrays;

/**
 * Created by amritachowdhury on 6/29/17.
 */
public class coding_10_11 {

    public void run() {
        int [] input = new int[] {9, 1, 0, 4, 8, 7};
        input = reArrange(input);
        System.out.print(Arrays.toString(input));
    }

    private int[] swapPositions(int [] input, int swapAt, int swapWith) {
        int temp = input[swapAt];
        input[swapAt] = input[swapWith];
        input[swapWith] = temp;
        return input;
    }

    private int[] reArrange(int[] input) {
        if (input.length <= 2) {
            return input;
        }
        int swapAt = 1;
        boolean isPeak = input[0] > input[1] ? true : false;

        for (int i = 1; i < input.length - 1; i++ ) {
            if (input[i] > input[i + 1] && !isPeak) {
                isPeak = true;
                input = swapPositions(input, swapAt, i);
                swapAt ++;
            } else if (input[i] < input[i + 1] && isPeak) {
                isPeak = false;
                input = swapPositions(input, swapAt, i);
                swapAt ++;
            }
        }
        input = swapPositions(input, swapAt, input.length - 1);
        return input;
    }

}
