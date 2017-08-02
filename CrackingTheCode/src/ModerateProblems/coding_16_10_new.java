package ModerateProblems;

import java.util.*;

/**
 * Created by amritachowdhury on 7/31/17.
 */
public class coding_16_10_new {
    public class People {
        int id; int birthYear; Integer deathYear;

        public People (int id, int birthYear, Integer deathYear) {
            this.id = id;
            this.birthYear = birthYear;
            this.deathYear = deathYear == null ? Integer.MAX_VALUE : deathYear;
        }
    }

    public void run() {
        List<People> people = getPeople();
        int year = maxYear(people);
        System.out.println(year);
    }

    private int maxYear(List<People> people) {
        int[] birthYear = populateYear(people, true);
        int[] deathYear = populateYear(people, false);
        int birthIdx = 0; int deathIdx = 0; int currentlyAlive = 0; int maxAlive = 0; int maxAliveYear = 0;
        while (birthIdx < birthYear.length) {
           if (birthYear[birthIdx] <= deathYear[deathIdx]) {
               currentlyAlive ++;
               if (currentlyAlive > maxAlive) {
                   maxAlive = currentlyAlive;
                   maxAliveYear = birthYear[birthIdx];
               }
               birthIdx++;
           } else if (birthYear[birthIdx] > deathYear[deathIdx]) {
               currentlyAlive --;
               deathIdx ++;
           }
        }
        return maxAliveYear;
    }

    private int[] populateYear(List<People> people, boolean getBirthYear) {
        int[] year = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            year[i] = getBirthYear == true ? people.get(i).birthYear : people.get(i).deathYear;
        }
        Arrays.sort(year);
        return year;
    }

    private List<People> getPeople() {
        List<People> people = new ArrayList<>();
        people.add(new People(1, 12, 15));
        people.add(new People(2, 20, 90));
        people.add(new People(3, 10, 98));
        people.add(new People(4, 01, 72));
        people.add(new People(5, 10, 98));
        people.add(new People(6, 23, 82));
        people.add(new People(7, 13, 98));
        people.add(new People(8, 90, 98));
        people.add(new People(9, 83, 99));
        people.add(new People(10, 75, 94));
        return people;

    }
}
