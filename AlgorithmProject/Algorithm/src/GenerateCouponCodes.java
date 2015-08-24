import java.util.Random;

/**
 * Created by achowdhury on 8/12/2015.
 */
public class GenerateCouponCodes {

    public void GenerateCodes(){
        String[] randomStrings = new String[5];
        Random random = new Random();
        for(int i = 0; i < 5; i++)
        {
            int max = 6; int min = 3;
            char[] word = new char[random.nextInt((max - min) + 1) + min]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('A' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
            System.out.println(randomStrings[i]);
        }
    }
}
