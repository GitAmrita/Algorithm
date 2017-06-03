package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by amritachowdhury on 5/1/17.
 */
public class coding_8_4 {
    List<String> sets = new ArrayList<>();
   // private List<String> subsets = new ArrayList<>();

    public void run() {
        sets.add("a1");
        sets.add("a2");
        sets.add("a3");

        List<String> subsets = printSubSet(sets, new ArrayList<String>());
        subsets.add(" ");

        for (String s : subsets) {
            System.out.println("(" + s + "), ");
        }


    }

    private List<String> printSubSet(List<String> sets, List<String> subsets) {
         if (sets.size() == 1) {
            subsets.add(sets.get(0));
        } else if(sets.size() == 2) {
            String no1 = sets.get(0);
            String no2 = sets.get(1);
            subsets.add(no1);
            subsets.add(no2);
            subsets.add(no1 + ", " + no2);
        } else {
            String lastNo = sets.remove(sets.size() - 1);
            printSubSet(sets, subsets);
            List<String> temp = new ArrayList<>(subsets);
            for (String s : temp) {
                String h = s + ", " + lastNo;
                subsets.add(h);
            }
            subsets.add(lastNo);
        }
        return subsets;
    }
}
