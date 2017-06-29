package SortingAndSearching;

import java.util.*;

/**
 * Created by amritachowdhury on 6/26/17.
 */
public class coding_10_2 {

    ArrayList<String> array = new ArrayList<>();

    public void run() {
        populateArrayList();
        findAnagrams();
        for (String s : array) {
            System.out.println(s);
        }
    }

    private void findAnagrams() {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: array) {
            String sorted = sortChar(s);
            if (map.get(sorted) == null) {
                List<String> val = new LinkedList<>();
                val.add(s);
                map.put(sortChar(s), val);
            } else {
                List<String> val = map.get(sorted);
                val.add(s);
                map.put(sortChar(s), val);
            }
        }
        array.clear();
        for (String s : map.keySet()) {
            array.addAll(map.get(s));
        }
    }

    private String sortChar(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    private void populateArrayList() {
        array.add("acre"); array.add("race"); array.add("bare"); array.add("care");
    }
}
