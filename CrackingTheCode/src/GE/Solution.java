package GE;

import java.util.*;

/**
 * Created by amritachowdhury on 8/3/17.
 */
public class Solution {

    public void run() {
        String[] votes = new String[] {"b", "b", "c", "a", "c", "a", "d"};
        String winner = electionWinner(votes);
        //return winner;

    }

    private String electionWinner(String[] votes) {
        String winner = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            String name = votes[i];
            if (map.get(name) == null) {
                map.put(name, 1);
            } else {
                int noOfVotes = map.get(name) + 1;
                map.put(name, noOfVotes);
            }
        }
        LinkedHashMap<String, Integer> temp = sortHashMapByValues(map);
        for (String key : temp.keySet()) {
            winner = key; break;
        }
        return winner;
    }

    public LinkedHashMap<String, Integer> sortHashMapByValues(
            HashMap<String, Integer> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues, Collections.<Integer>reverseOrder());
        Collections.sort(mapKeys, Collections.<String>reverseOrder());

        LinkedHashMap<String, Integer> sortedMap =
                new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1 == comp2) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }
}
