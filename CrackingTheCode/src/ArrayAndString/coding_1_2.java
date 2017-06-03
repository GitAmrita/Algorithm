package ArrayAndString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amritachowdhury on 5/25/17.
 */
public class coding_1_2 {
    Map<Character, List<Integer>> map = new HashMap<>();

    public void run() {
        String str1 = "aaba"; String str2 = "bamglkamrab";
        boolean isStringAPalindrome = isAPalindrome(str1, str2);
        System.out.println(isStringAPalindrome);
    }

    private String getSmallerString(String str1, String str2) {
        return str1.length() > str2.length() ? str2 : str1;
    }

    private void fillMap(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                List<Integer> pos = new ArrayList<>();
                pos.add(i);
                map.put(s.charAt(i), pos);
            } else {
                List<Integer> pos = map.get(s.charAt(i));
                pos.add(i);
                map.put(s.charAt(i), pos);
            }
        }
    }

    private int matchAtPos(List<Integer> pos, int minPos) {
        if (pos == null) {
            return -1;
        }
        int count = 0;
        for (int i : pos) {
            if (i > minPos) {
                pos.remove(count);
                return i;
            }
            count ++;
        }
        return -1;
    }


    private boolean isAPalindrome(String str1, String str2) {
        int minPos = -1;
        String palindrome = getSmallerString(str1, str2);
        String parent = palindrome.equals(str1) ? str2 : str1;
        fillMap(parent);
        for (int i = 0; i < palindrome.length(); i++) {
            List<Integer> posList = map.get(palindrome.charAt(i));
            minPos = matchAtPos(posList, minPos);
            if (minPos < 0) {
                return false;
            }
        }
        return true;
    }
}
