package Recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by amritachowdhury on 5/31/17.
 */
public class googleCombination {

    private static final String OPEN_BRACE = "{";
    private static final String CLOSE_BRACE = "}";

    public void run() {
        List<Integer> n = new LinkedList<>();
        n.add(1); n.add(2); n.add(3);
        List<String> p = printCombinations(n, new LinkedList<String>());
        p.add(formatString(""));
        for (String d : p) {
            System.out.println(d);
        }
    }

    private List<String> printCombinations(List<Integer> numbers, List<String> result) {
        if (numbers.size() == 1) {
            result.add(formatString(String.valueOf(numbers.get(0))));
            return result;
        } else {
            String no = String.valueOf(numbers.get(0));
            numbers.remove(0);
            printCombinations(numbers, result);
            List<String> temp = new LinkedList<>(result);
            for (String k : temp) {
                result.add(formatString(no + ", " + getRawString(k) ));
            }
            result.add(formatString(no));
            return result;
        }
    }

    private String formatString(String rawString) {
        return OPEN_BRACE + rawString + CLOSE_BRACE;
    }

    private String getRawString(String formattedString) {
        return formattedString.substring(1, formattedString.length() - 1); // get rid of braces
    }
}
