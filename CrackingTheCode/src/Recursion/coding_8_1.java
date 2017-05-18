package Recursion;

/**
 * Created by amritachowdhury on 4/29/17.
 */
public class coding_8_1 {

    public void count() {
        int no = countStairHop(4);
        System.out.println(no);
    }

    public int countStairHop(int noOfStair) {
        if (noOfStair <= 0) {
            return 0;
        } else  if (noOfStair == 1) {
            return 1;
        } else  if (noOfStair == 2) {
            return 2;
        } else  if (noOfStair == 3) {
            return 4;
        } else {
            return countStairHop(noOfStair - 1) + countStairHop(noOfStair - 2)
                    + countStairHop(noOfStair - 3) ;
        }
    }
}
