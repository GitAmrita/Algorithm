package ModerateProblems;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by amritachowdhury on 7/3/17.
 */
public class coding_16_10 {
    public class People {
        int id; int birthYear; Integer deathYear;

        public People (int id, int birthYear, Integer deathYear) {
            this.id = id;
            this.birthYear = birthYear;
            this.deathYear = deathYear == null ? Integer.MAX_VALUE : deathYear;
        }
    }

    public void run() {
        List<People> people = new LinkedList<>();
        getPeople(people);
        int maxYear = maxAliveYear(people);
        System.out.println(maxYear);
    }

    private void getPeople(List<People> people) {
        people.add(new People(1, 1985, 2016));
        people.add(new People(2, 1980, 2000));
        people.add(new People(3, 1985, 2016));
        people.add(new People(4, 1981, 1984));
        people.add(new People(5, 1997, null));

    }

    private int maxAliveYear(List<People> peeps) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (People p : peeps) {
            incrementFrequency(p.birthYear, map);
            if (p.deathYear == null || p.birthYear != p.deathYear) {
                incrementFrequency(p.deathYear, map);
            }

            for (Integer key : map.keySet()) {
                if (key <= p.birthYear) {
                    continue;
                } else if (key > p.birthYear && key < p.deathYear) {
                    incrementFrequency(key, map);
                } else {
                    break;
                }
            }
        }
        return findMaxPopulationYear(map);
    }

    private int findMaxPopulationYear(Map<Integer, Integer> map) {
        int maxYear = 0, maxValue = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            if (map.get(key) > maxValue) {
                maxValue = map.get(key);
                maxYear = key;
            }
        }
        return maxYear == Integer.MAX_VALUE ? 2017 : maxYear;
    }

    private void incrementFrequency(Integer year, Map<Integer, Integer> map) {
        if (map.get(year) != null) {
            map.put(year, map.get(year) + 1);
        } else {
            map.put(year, 1);
        }
    }
}
