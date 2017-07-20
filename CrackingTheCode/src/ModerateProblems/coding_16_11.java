package ModerateProblems;

import java.util.ArrayList;


/**
 * Created by amritachowdhury on 7/4/17.
 */
public class coding_16_11 {

    public void run() {
        ArrayList<Integer> distinctLengths = getDistinctDivingPlanks(5, 3, 10);
        int h = distinctLengths.size();
        for (int i : distinctLengths) {
            System.out.println("Size : " + i);
        }
    }

    private ArrayList<Integer> getDistinctDivingPlanks(int k, int shorter, int longer) {
        ArrayList<Integer> lengths = new ArrayList<>();
        for (int iShort = 0; iShort <= k; iShort++ ) {
            int iLong = k - iShort;
            int length = iShort * shorter + iLong * longer;
            lengths.add(length);
        }
        return lengths;
    }
}
