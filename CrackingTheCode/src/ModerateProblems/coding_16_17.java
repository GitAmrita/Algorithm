package ModerateProblems;

import static java.lang.Math.max;

/**
 * Created by amritachowdhury on 7/12/17.
 */
public class coding_16_17 {

    /*public void run() {
        int input[] = {2, -8, 3, -2, 4, -10};
        int maxSum = Integer.MIN_VALUE; int maxEnd = 0; int maxStart = 0;
        for (int i = 0; i< input.length; i++) {
            int start = i;
            int end = start;
            int temp = 0;
            int sum = input[i];
            for (int j = i; j < input.length; j++) {
                temp += input[j];
                if (sum <= temp) {
                    sum = temp;
                    end = j;
                }
            }
            if (maxSum < sum) {
                maxSum = sum;
                maxEnd = end;
                maxStart = start;
            }
        }
        System.out.println("max Sum : " + maxSum);
        for ( int k = maxStart; k <= maxEnd; k++) {
            System.out.print(input[k] + ", ") ;
        }
    }*/

    public void run() {
        int input[] = {2, -3, 4, -1, -2, 1, 5, -3};
        int currSum = input[0];
        int maxSum = input[0]; int start = 0; int end = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i] >= currSum + input[i]) {
                start = i;
                currSum = input[i];
            } else {
                currSum += input[i];
            }
            if (maxSum <= currSum) {
                end = i;
                maxSum = currSum;
            }
        }
        System.out.println(maxSum);
        System.out.println(start + " : " + end);
    }
}
