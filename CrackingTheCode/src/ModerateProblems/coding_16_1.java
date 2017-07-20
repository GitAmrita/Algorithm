package ModerateProblems;

/**
 * Created by amritachowdhury on 7/2/17.
 */
public class coding_16_1 {

    public void run() {
        int a = 5, b = 7;
        numberSwapper(a, b);
    }
    private void numberSwapper(int a, int b) {
        b = a + b;
        a = b - a;
        b = b - a;
        System.out.println("a : " + a + " b : " + b);
    }
}
