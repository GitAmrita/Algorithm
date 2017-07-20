package ModerateProblems;

import java.util.Arrays;

/**
 * Created by amritachowdhury on 7/3/17.
 */
public class coding_16_6 {

    public void run() {
        int[] a = {1, 3, 15, 11, 2}; int [] b = {23, 127, 235, 19, 8};
        String smallestPair = smallestDifference( a,  b);
        System.out.println(smallestPair);
    }

    private String smallestDifference(int[] a1, int[] b1) {
        Arrays.sort(a1); Arrays.sort(b1);
        int a = 0, b = 0, lowestDifference = Integer.MAX_VALUE, pair1 = 0, pair2 = 0;
        while (a < a1.length && b < b1.length) {
            if (a1[a] == b1[b]) {
                return "( " + a1[a] + ", " + b1[b] + " )";
            } else if (a1[a] < b1[b]) {
                 if (b1[b] - a1[a] < lowestDifference) {
                     pair1 = b1[b];
                     pair2 = a1[a];
                     lowestDifference = b1[b] - a1[a];
                 }
                 a++;
            } else {
                if (a1[a] - b1[b] < lowestDifference) {
                    pair1 = a1[a];
                    pair2 = b1[b];
                    lowestDifference = a1[a] - b1[b];
                }
                b++;
            }
        }
        return "( " + pair1 + ", " + pair2 + " )";
    }

}
