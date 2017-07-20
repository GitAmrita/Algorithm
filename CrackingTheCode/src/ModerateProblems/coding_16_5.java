package ModerateProblems;

/**
 * Created by amritachowdhury on 7/3/17.
 */
public class coding_16_5 {

    public void run() {
        // naive method
        /*long factorialComputed = factorial(10);
        System.out.println(factorialComputed);
        int countOfZero = calculateTrailingZeros(String.valueOf(factorialComputed));
        System.out.println(countOfZero);*/

        // smart method
        int count = countTrailingZeros(23);
        System.out.println(count);
    }

    // naive method
    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private int calculateTrailingZeros(String factorial) {
        int count = 0;
        for (int i = factorial.length() - 1; i >= 0; i--) {
            if (Integer.parseInt(String.valueOf(factorial.charAt(i))) == 0) {
                count++;
            }
        }
        return count;
    }
    // naive method

    private int countTrailingZeros(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            count += countFiveFactor(i);
        }
        return count;
    }

    private int countFiveFactor(int factorialOf) {
        int count = 0;
        while (factorialOf % 5 == 0) {
            count++;
            factorialOf = factorialOf / 5;
        }
        return count;
    }
}
