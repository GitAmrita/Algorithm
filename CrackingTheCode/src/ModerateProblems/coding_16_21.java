package ModerateProblems;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by amritachowdhury on 7/4/17.
 */
public class coding_16_21 {

    private void swapNumbers(int [] a, int [] b) {
        int sumA = getSum(a);
        int sumB = getSum(b);
        int differenceInSwapValues;
        if (sumA > sumB) {
            differenceInSwapValues = (sumA - sumB) / 2;
            getSwapValues(differenceInSwapValues, a, b);
        } else {
            differenceInSwapValues = (sumB - sumA) / 2;
            getSwapValues( differenceInSwapValues, b, a);
        }
    }

    private int getSum(int[] x) {
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum = sum + x[i];
        }
        return sum;
    }

    private void getSwapValues(int differenceInSwapValues, int[]iterate, int[]putInHash) {
        Map<Integer, Integer> map = new HashMap<>();
        int aSwap,  bSwap;
        for (int i = 0; i < putInHash.length; i++) {
            map.put(putInHash[i], 1);
        }

        for (int j = 0; j < iterate.length; j++) {
            aSwap = iterate[j];
            if (map.get(aSwap - differenceInSwapValues) != null) {
                bSwap = map.get(aSwap - differenceInSwapValues);
                System.out.println(aSwap);
                System.out.println(bSwap);
                break;
            }
        }
    }

    public void run() {
        int[] a = new int[] {4, 1, 2, 1, 1, 2};
        int[] b = new int[] {3, 6, 3, 3};
        swapNumbers(a, b);
    }
}
