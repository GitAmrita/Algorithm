package ModerateProblems;

import java.util.Random;

/**
 * Created by amritachowdhury on 7/6/17.
 */
public class coding_16_23 {

    public void run() {
        for (int i = 0; i < 10; i++) {
            int no = rand7();
            System.out.println(no);
        }
    }

    private int rand7() {
        while (true) {
            int no = 5 * rand5() + rand5();
            if ( no < 21) {
                return no % 7;
            }
        }
    }

    private int rand5() {
        int max = 4, min = 0;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
