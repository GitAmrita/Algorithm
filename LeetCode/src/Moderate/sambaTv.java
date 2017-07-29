package Moderate;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by amritachowdhury on 7/26/17.
 */
public class sambaTv {

    private Integer highCardWinner(LinkedHashMap<Integer, Integer> map1,  LinkedHashMap<Integer, Integer> map2) {
        Iterator<Map.Entry<Integer, Integer>> iter1 = map1.entrySet().iterator();
        Iterator<Map.Entry<Integer, Integer>> iter2 = map2.entrySet().iterator();
        while(iter1.hasNext() || iter2.hasNext()) {
            Map.Entry<Integer, Integer> e1 = iter1.next();
            Map.Entry<Integer, Integer> e2 = iter2.next();
            Integer key1 = e1.getKey();
            Integer key2 = e2.getKey();
            if (key1 > key2) {
                return 1;
            } else if (key2 > key1) {
                return 2;
            }

        }
        return null;
    }
}
