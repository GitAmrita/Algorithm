package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amritachowdhury on 5/1/17.
 */
public class coding_8_7 {
    List<String> permutations = new ArrayList<>();

    public void getPermutations() {
        String word = "balm";
        getPermutations(word);
        for (String s : permutations) {
            System.out.println(s);
        }
    }

    private void getPermutations(String word) {
        if (word.length() == 1) {
            permutations.add(word);
        } else if (word.length() == 2) {
            permutations.add(word);
            permutations.add(word.substring(1) + word.substring(0, 1));
        } else {
            String letter = word.substring(0, 1);
            String remainingWord = word.substring(1) ;
            getPermutations(remainingWord);
            insertCharAtPossiblePlaces(letter);
        }
    }

    private void insertCharAtPossiblePlaces(String letter) {
        List<String> temp = new ArrayList<>(permutations);
        for (String s : temp) {
            for (int j = 0; j <= s.length(); j++) {
                String newWord = s.substring(0, j) + letter + s.substring(j);
                permutations.add(newWord);
            }
            permutations.remove(s);
        }
    }
}
