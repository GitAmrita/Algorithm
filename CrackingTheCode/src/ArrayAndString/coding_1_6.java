package ArrayAndString;

/**
 * Created by amritachowdhury on 5/27/17.
 */
public class coding_1_6 {

    public void run() {
        String input = "aavg";
        String output = stringCompression(input);
        System.out.print(output);
    }

    private String stringCompression(String input) {
        StringBuilder output = new StringBuilder(input.length() * 2);
        int freq = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                freq++;
            } else {
                output.append(input.charAt(i) + String.valueOf(freq));
                freq = 1;
            }
        }
        output.append(input.charAt(input.length() - 1) + String.valueOf(freq));
        return output.toString().length() < input.length() ? output.toString() : input;
    }
}
