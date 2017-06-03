package ArrayAndString;

/**
 * Created by amritachowdhury on 5/27/17.
 */
public class coding_1_9 {

    public void run() {
        String s1 = "waterbottle"; String s2 = "erbottlewat";
        boolean isARotation = isRotation(s1, s2);
        System.out.println(isARotation);
    }

    private boolean isRotation(String original, String subString) {
        String newSubString = subString + subString;
        return newSubString.contains(original);
    }
}
