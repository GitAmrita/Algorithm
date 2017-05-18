package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by amritachowdhury on 5/3/17.
 */
public class coding_8_8 {
    Set<Character> characterSet = new HashSet<>();
    List<String> permutations = new ArrayList<>();

    public void getPermutations() {
        String word = "lcal";
        String uniqueString = removeDuplicateCharacter(word);
        getPermutations(uniqueString);
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

    private String removeDuplicateCharacter(String str) {
        String uniqueWord = "";
        for (char s: str.toCharArray()) {
            if (characterSet.contains(s)) {
                continue;
            } else {
                characterSet.add(s);
                uniqueWord += s;
            }
        }
        return uniqueWord;
    }
}
