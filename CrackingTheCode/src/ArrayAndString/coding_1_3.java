package ArrayAndString;

/**
 * Created by amritachowdhury on 5/25/17.
 */
public class coding_1_3 {

    public void run() {
        String s = "Mr John Smith    ";
        char [] input = s.toCharArray();
        input = urlify(input, 13);
        System.out.println("char[] b: " + new String(input));
    }

    private char[] urlify(char[] input, int actualLength) {
        int wordPos = actualLength - 1;
        for (int j = input.length - 1; j >= 0 ; j--) {
            char presentChar = input[wordPos];
            if (presentChar != ' ') {
                input[j] = presentChar;
            } else {
                input[j] = '0';
                input[j - 1] = '2';
                input[j - 2] = '%';
                j = j - 2;
            }
            wordPos --;
        }
        return input;
    }
}
