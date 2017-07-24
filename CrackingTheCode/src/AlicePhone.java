import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by amritachowdhury on 7/22/17.
 */
public class AlicePhone {
    Set<Integer> set = new HashSet<>();
    public void run() {
        int [] a = new int [] {1, 5, 3, 4, 2};
        int k = 1;
        int pair = kDifference(a, k);
        System.out.println(pair);

    }

    private int kDifference(int [] a, int k) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int requiredNoPos = a[i] + k;
            int requiredNoNeg = a[i] - k;
            count += getCount(requiredNoPos, a[i]);
            count += getCount(requiredNoNeg, a[i]);
        }
        return count;
    }

    private int getCount(int requiredNo, int no) {
        int count = 0;
        if (!set.contains(requiredNo)) {
            set.add(no);
        } else {
            set.remove(requiredNo);
            count++;
        }
        return count;
    }
}

