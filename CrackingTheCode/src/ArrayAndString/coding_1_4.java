package ArrayAndString;

/**
 * Created by amritachowdhury on 5/25/17.
 */
public class coding_1_4 {

    public void run() {
        String s = "taco cat";
        boolean result = ispermutationOfPalindrome(s);
        System.out.print(result);
    }

    private boolean ispermutationOfPalindrome(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitIsSet(bitVector);
    }

    private int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if ( a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    private int toggle(int bitVector, int index) {
        if (index < 0) {
            return bitVector;
        }
        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    private boolean checkExactlyOneBitIsSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }
}
