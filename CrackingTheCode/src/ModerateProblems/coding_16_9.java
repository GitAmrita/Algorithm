package ModerateProblems;

/**
 * Created by amritachowdhury on 7/3/17.
 */
public class coding_16_9 {

    public void run() {
        int multiplication = multiply(7, 3);
        System.out.println(multiplication);

        int subtraction = subtract(7, -3);
        System.out.println(subtraction);

        int division = divide(27, 3);
        System.out.println(division);
    }

    private int divide(int a, int b) {
        if ( a < b) {
            return 0;
        }
        int i = Integer.MAX_VALUE; int count = 0;
        while (i != 0) {
            i = subtract(a, b);
            a = i;
            count++;
        }
        return count;
    }

    private int subtract(int a, int b) {
        if ( a < 0 && b < 0) {
            return getNegativeValue(a + b);
        }
        if ( b <= 0) {
            return a + getNegativeValue(b);
        } else {
            return a + getNegativeValue(Math.abs(b));
        }
    }

    private int multiply(int a, int b) {
        int value = 0;
        int multiplier = a >= b ? b : a;
        int multiplicand = a == multiplier ? b : a;
        for (int i = 0; i < Math.abs(multiplier); i++) {
            value = value + Math.abs(multiplicand);
        }
        if ( (a > 0 && b > 0) || (a < 0 && b < 0)) {
            return value;
        } else {
            return  getNegativeValue(value);
        }
    }

    private int getNegativeValue(int a) {
        int multiplicand = -1, val = 0;
        for (int i = 0; i < a; i++) {
            val += multiplicand;
        }
        return val;
    }
}
