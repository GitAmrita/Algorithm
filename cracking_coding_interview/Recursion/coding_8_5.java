package Recursion;

/**
 * Created by amritachowdhury on 5/1/17.
 */
public class coding_8_5 {
    int a1 = 10; int a2 = 0;
    int sum = a1;

    public void getMultiply() {
        int i = multiply(a1);
        if (a1 % 2 == 1 && a1 != 1) {
            i += a2;
        }
        System.out.print(String.valueOf(i));
    }

    private int multiply(int a1) {
        if (a1 == 0 || a2 == 0) {
            return 0;
        }
       else  if (a1 == 1) {
            return a2;
        }
        else if (a1 == 2) {
            return a2 + a2;
        } else {
            a1 = a1 / 2;
            return multiply(a1) + multiply(a1);
        }
    }
}
