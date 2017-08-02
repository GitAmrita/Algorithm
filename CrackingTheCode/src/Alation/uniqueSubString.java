package Alation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// given a string find the longest unique sub string
/**
 * Created by amritachowdhury on 8/1/17.
 */
public class uniqueSubString {

    String input = "dvdf"; //"bbtablud"
    public void run() {
        String s = getLargestUniqueSubString(input);
        System.out.println(s);
    }

    private int getIndexToDelete(StringBuilder sb, String target) {
        int idx = 0;
        while (idx < sb.toString().length()) {
            String g = String.valueOf(sb.charAt(idx));
            if (g.equals(target)) {
                break;
            }
            idx++;
        }
        return idx;
    }

    private String getLargestUniqueSubString(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        List<String> tempHolder = new ArrayList<>(); int startedFrom = 0; int maxLength = 0;
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (map.get(str) == null) {
                sb.append(str);
            } else {
                int duplicateIdx = map.get(str);
                if (duplicateIdx >= startedFrom) {
                    startedFrom = duplicateIdx + 1;
                    if (maxLength < sb.toString().length()) {
                        tempHolder.add(sb.toString());
                        maxLength = sb.toString().length();
                    }
                    int idxToDelete = getIndexToDelete(sb, str);
                    sb.delete(0, idxToDelete + 1);
                    sb.append(str);
                } else {
                    sb.append(str);
                }
            }
            map.put(str, i);
        }
        if (maxLength < sb.toString().length()) {
            tempHolder.add(sb.toString());
        }
        return tempHolder.get(tempHolder.size() - 1);
    }
}
