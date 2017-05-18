package Recursion;

import java.util.*;

/**
 * Created by amritachowdhury on 5/6/17.
 */
public class coding_8_9 {
    List<String> result = new ArrayList<>();

    public void print() {
        getValidCombinations(3);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private void getValidCombinations(int no) {
        if (no == 1) {
            result.add("()");
        } else {
            getValidCombinations(no - 1);
            List<String> temp = new ArrayList<>(result);
            for (String s : temp) {
                String formattedString = formatData(s);
                String[] parts = formattedString.split(",");
                for (int i = 0; i < parts.length; i++) {
                    String temp1 = "(" + parts[i] + ")";
                    String newCombination = getPrefix(i, parts) + temp1 + getSuffix(i, parts);
                    result.add(newCombination);
                }
                result.remove(s);
            }
            result.add(getIndividual(no));
        }
    }

    private String formatData(String s) {
        if (s.equals( "()"))
            return s;
        if (s.equals("()()"))
            return "(),()";
        else return "(())";
    }

    private String getPrefix(int prefix, String[] parts) {
        String prefixStr = "";
        for (int i = 0; i < prefix; i++) {
            prefixStr += parts[i];
        }
        return prefixStr;
    }

    private String getSuffix(int suffix, String[] parts) {
        String suffixStr = "";
        for (int i = suffix + 1; i < parts.length; i++) {
            suffixStr += parts[i];
        }
        return suffixStr;
    }

    private String getIndividual(int no) {
        String s = "";
        for (int i = 0; i < no; i++) {
            s += "()";
        }
        return s;
    }
}
