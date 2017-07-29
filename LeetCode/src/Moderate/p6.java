package Moderate;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by amritachowdhury on 7/26/17.
 */
public class p6 {

    LinkedHashMap<Integer, Integer> map1 = new LinkedHashMap<Integer, Integer>();
    LinkedHashMap<Integer, Integer> map2 = new LinkedHashMap<Integer, Integer>();

    public void run () {
        putInMap(5, map1);
        putInMap(1, map1);
        putInMap(2, map1);
        putInMap(4, map1);

        putInMap(8, map2);
        putInMap(7, map2);
        putInMap(5, map2);
        putInMap(1, map2);

        Integer h = highCardWinner();
        if (h != null) {
            System.out.println(h);
        } else {
            System.out.println("draw");
        }


    }

    private void putInMap(int key, LinkedHashMap<Integer, Integer> map) {
        int f = 0;
        if (map.get(key) != null) {
            f = map.get(key) + 1;
        } else {
            f = 1;
        }
        map.put(key, f);
    }

    private Integer highCardWinner() {
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

    /*private static Integer highCardWinner (LinkedHashMap<Integer, Integer> map1,  LinkedHashMap<Integer, Integer> map2) {
        Map.Entry<Integer,Integer> entry = map1.entrySet().iterator().next();
        Map.Entry<Integer,Integer> entry1 = map2.entrySet().iterator().next();
        while (true) {
            Integer key1 = entry.getKey();
            Integer key2 = entry1.getKey();
            if (key1 > key2) {
                return 1;
            } else if (key2 > key1) {
                return 2;
            } else {
                entry = map1.entrySet().iterator().next();
                entry1 = map2.entrySet().iterator().next();
         if (entry == null || entry1 == null) {
           return null;
         }
            }
        }

    }*/
}
