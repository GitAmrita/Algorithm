package FiveStarPhoneInterview;

import java.util.Arrays;

/**
 * Created by amritachowdhury on 6/8/17.
 */
public class FibonacciSeriesDynamicProgramming {

    public void run() {
        int[] series = getFibonacciNumber(6);
        System.out.println(Arrays.toString(series));
    }

    private int[] getFibonacciNumber(int seriesLength) {
        int [] cache = new int[seriesLength + 1];
        int n = 0;
        while (seriesLength >= 0) {
            if (n == 0 || n == 1) {
                cache[n] = n;
            } else {
                cache[n] = cache[n - 1] + cache[n - 2];
            }
            seriesLength--;
            n++;
        }
        return cache;
    }
}
