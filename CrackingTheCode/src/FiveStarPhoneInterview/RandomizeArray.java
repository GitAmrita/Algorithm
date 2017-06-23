package FiveStarPhoneInterview;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by amritachowdhury on 6/7/17.
 */
//https://www.glassdoor.com/Interview/FiveStars-Software-Engineer-Interview-Questions-EI_IE447133.0,9_KO10,27.htm
//random array shuffling
//http://www.geeksforgeeks.org/shuffle-a-given-array/
public class RandomizeArray {
    Random rand = new Random();

    public void run() {
        int[] input = new int[] {6, 5, 3, 10, 1, 15, 0, 8};
        int[] randomizedArray = generateRandomArray(input);
        printArray(randomizedArray);
    }

    private int[] generateRandomArray(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int randomIndex = generateRandomIndex(0, input.length - 1 - i );
            int swappable = input[i];
            input[i] = input[randomIndex];
            input[randomIndex] = swappable;
        }
        return input;
    }

    private int generateRandomIndex(int min, int max) {
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

    private void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
