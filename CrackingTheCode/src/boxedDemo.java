/**
 * Created by amritachowdhury on 7/8/17.
 */
public class boxedDemo {

    int[]a = new int[] {0, -2147483648, -2147483648};
    public long solution() {
        long sum = getSum(a);
        long equilibriumIndex = getEquilibriumPosition(sum, a);
        return equilibriumIndex;
    }

    private long getSum(int[] input) {
        long sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum = sum + input[i];
        }
        return sum;
    }

    private long getEquilibriumPosition(long sum, int[] input) {
        long leftSum = 0; long rightSum = 0;
        for (int i = 0; i < input.length; i++) {
            if (i > 0) {
                leftSum += input[i - 1];
            }
            rightSum = sum - input[i] - leftSum;
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
