package Quora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by amritachowdhury on 7/18/17.
 */
public class Upvotes {

    public void run() {
        q1();
    }

    public void q1() {
        Scanner scan = new Scanner(System.in);
        String line1Input = scan.nextLine();
        int n = Integer.parseInt(line1Input.split("\\s+")[0]);
        int k = Integer.parseInt(line1Input.split("\\s+")[1]);
        int [] upVote = new int [n];
        String line2Input = scan.nextLine();
        String[] upVoteInput = line2Input.split("\\s+");
        for (int m = 0; m < n; m++) {
            upVote[m] = Integer.parseInt(upVoteInput[m]);
        }
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i <= n - k; i++) {
            int res = countTotalUpVotes(i, k, upVote);
            results.add(res);
        }
        for (int p = 0; p < results.size(); p++) {
            System.out.println(results.get(p));
        }
    }



    private static int countTotalUpVotes(int start, int window,  int[] upVote) {
        int nonIncreasing = 0; int nonDecreasing = 0;
        for (int i = start; i < start + window - 1; i++) {
            int lastNo = upVote[i];
            for (int j = i + 1; j < start + window; j++) {
                if (lastNo > upVote[j]) {
                    nonIncreasing++;
                } else if (lastNo < upVote[j]) {
                    nonDecreasing++;
                }
                lastNo = upVote[j];
            }
        }
        return nonDecreasing - nonIncreasing;
    }


}
