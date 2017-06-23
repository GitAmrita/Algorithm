package FiveStarPhoneInterview;

import java.util.*;

/**
 * Created by amritachowdhury on 6/7/17.
 */
public class FibbonacciSeriesRecursion {

    Map<Integer, Integer> map = new HashMap<>();

    public void run() {
        List<Integer> series = getFibonacciSeries(6);
        System.out.println(Arrays.toString(series.toArray()));
    }

    private int getFibonacciNo(int n) {
        if (n == 0) {
            map.put(0, 0);
            return 0;
        } else if (n == 1) {
            map.put(1, 1);
            return 1;
        } else {
            int no1, no2;
            if (map.get(n - 1) == null) {
                no1 = getFibonacciNo(n - 1);
                map.put(n - 1, no1);
            } else {
                no1 = map.get(n - 1);
            }

            if (map.get(n - 2) == null) {
                no2 = getFibonacciNo(n - 2);
                map.put(n - 2, no2);
            } else {
                no2 = map.get(n - 2);
            }
            return no1 + no2;
        }
    }

    private List<Integer> getFibonacciSeries(int n) {
        int no = 0;
        List<Integer> series = new LinkedList<>();
        while (no < n) {
            series.add(getFibonacciNo(no));
            no++;
        }
        return series;
    }
}
