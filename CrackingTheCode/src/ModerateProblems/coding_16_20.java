package ModerateProblems;



import java.util.*;

/**
 * Created by amritachowdhury on 7/12/17.
 */
public class coding_16_20 {
    Map<Character, Integer> keypad = new HashMap<>();
    List<String> dictionary = new ArrayList<>();
    String input = "8733";

    public void run() {
        List<String> output = new ArrayList<>();
        fillDictionary();
        fillKeyPad();
        for(String s : dictionary) {
            StringBuilder sb = new StringBuilder(input);
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (isContains(s.charAt(i), sb.toString())) {
                    word.append(s.charAt(i));
                    sb.deleteCharAt(0);
                } else {
                    break;
                }
            }
            if (!word.toString().isEmpty()) {
                output.add(word.toString());
            }
        }
        printOutput(output);
    }

    private void printOutput(List<String> output) {
        System.out.print(java.util.Arrays.toString(output.toArray()));
    }

    private boolean isContains(Character c, String input) {
        return input.contains(String.valueOf(keypad.get(c)));

    }

    private void fillDictionary() {
        dictionary.add("tree"); dictionary.add("used"); dictionary.add("bark");
    }

    private void fillKeyPad() {
        keypad.put('a', 2); keypad.put('b', 2); keypad.put('c', 2);
        keypad.put('d', 3); keypad.put('e', 3); keypad.put('f', 3);
        keypad.put('g', 4); keypad.put('h', 4); keypad.put('i', 4);
        keypad.put('j', 5); keypad.put('k', 5); keypad.put('l', 5);
        keypad.put('m', 6); keypad.put('n', 6); keypad.put('o', 6);
        keypad.put('p', 7); keypad.put('q', 7); keypad.put('r', 7); keypad.put('s', 7);
        keypad.put('t', 8); keypad.put('u', 8); keypad.put('v', 8);
        keypad.put('w', 9); keypad.put('x', 9); keypad.put('y', 9); keypad.put('z', 9);
    }
}
