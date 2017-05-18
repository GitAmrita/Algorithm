package Recursion;

/**
 * Created by amritachowdhury on 5/6/17.
 */
public class coding_8_11 {
    int denoms[] = new int[] {25, 10, 5, 1};
    public void makeChange() {
        int amount = 100;
        int ways = makeChange(amount, denoms,  0);
        System.out.print(ways);

    }
    private int makeChange(int amount, int[] denom, int index) {
        if (index >= denoms.length - 1) {
            return 1;
        }
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0;  i * denomAmount <= amount; i++) {
            int remainingChange = amount - i * denomAmount;
            ways += makeChange(remainingChange, denoms, index + 1);
        }
        return ways;
    }
}
