package ArrayAndString;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by amritachowdhury on 5/22/17.
 */
public class coding_1_1 {

    public void run() {
        String input = "asdrASDR";
       boolean isUniqueString =  isUnique(input);
       System.out.print(isUniqueString);
    }

    private boolean isUnique(String str) {
        char[] charArray = str.toLowerCase().toCharArray();
        Arrays.sort(charArray);
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[ i + 1]) {
                return false;
            }
        }
        return true;
    }
}
