package ModerateProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amritachowdhury on 7/6/17.
 */
public class coding_16_24 {

    public void run() {
        int [] input = new int[] {-2, -1, 0, 3, 5, 6, 7, 9, 13, 14};
        List<String> pairs = pairNo(input, 23);
        System.out.println(Arrays.toString(pairs.toArray()));
    }

    private List<String> pairNo(int [] input, int targetSum) {
        Arrays.sort(input);
        List<String> pairs = new ArrayList<>();
        int start = 0; int end = input.length - 1;
        while (start < end) {
            int val = input[start] + input[end];
            if (val > targetSum) {
                end--;
            } else if (val == targetSum) {
                pairs.add( "( " + input[start] + ", " + input[end] + " )");
                end --;
                start++;
            } else {
                start++;
            }
        }
        return pairs;
    }
}
