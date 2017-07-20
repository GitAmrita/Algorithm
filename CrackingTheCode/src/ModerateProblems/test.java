package ModerateProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amritachowdhury on 7/5/17.
 */
public class test {

    public void run() {
        List<Integer> a = new ArrayList<>();
        a.add(3); a.add(1); a.add(1); a.add(2); a.add(2);
       // int x = singleNumber(a);
       // int x = countSetBits(00000000000000000000000000001011);
        int x = gcd(3, 9);
        System.out.println(x);
        t();
    }

    private int singleNumber(final List<Integer> A) {
        int num = 0;
        for (int val : A) {
            num ^= val;
        }
        return num;

    }

    private int countSetBits(long a) {
        int count = 0; int times = 0;
        while (a != 0) {
            count += a & 1;
            a >>= 1;
            times ++;
        }
        System.out.println("times" + times);
        return count;
    }

    private int gcd(int a, int b) {
        int bigger = a > b ? a : b;
        int smaller = a > b ? b : a;
        int temp = smaller;
        while (smaller != 0 && bigger % smaller != 0 ) {
            temp = bigger % smaller;
            bigger = smaller;
            smaller = temp;
        }
        return temp;
    }

    private void t() {
        int p = 0 % 7;
        int q = 1 % 7;
        int r = 7 % 7;
        int s = 6 % 7;
        System.out.println(p);
    }

}
