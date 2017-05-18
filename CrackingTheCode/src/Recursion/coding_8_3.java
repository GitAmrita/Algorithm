package Recursion;

/**
 * Created by amritachowdhury on 4/29/17.
 */
public class coding_8_3 {

    int a[];

    public void isMagicNoPresent() {
       // fillArrayWithDistinctValues();
        fillArrayWithoutDistinctValues();
        boolean isFound = checkMagicNo();
        System.out.print(isFound);
    }

    private boolean checkMagicNo() {
        int i = 0;
        while(i < a.length) {
            if (a[i] == i) {
                return true;
            }
            if (a[i] < i) {
                i++;
            } else {
                i = a[i] + 1;
            }
        }
        return false;
    }

    private void fillArrayWithoutDistinctValues() {
        a = new int[] { -3, 2, 5, 5, 6, 6, 6, 6, 12, 12 };
    }

    private void fillArrayWithDistinctValues() {
        a = new int[10];
        int min = - 50;
        int max = 8;
        for (int i = 0; i < 9; i++) {
            int no = generateRandomNo(min, max);
            a[i] = no;
            min = no + 1;
            if (no == max) {
                max ++;
            }
        }
        a[9] = 9;
       /* min = 7;
        max = 20;
        for (int i = 6; i < 10; i++) {
            int no = generateRandomNo(min, max);
            a[i] = no;
            min = no + 1;
            if (no == max) {
                max ++;
            }
        }*/

        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }

    private int generateRandomNo(int min, int max) {
        return  (int )(Math.random() * max + min);
    }
}
