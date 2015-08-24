/**
 * Created by achowdhury on 6/8/2015.
 */

/*
 Write a method to count the number of 2’s between 0 and n.
 EXAMPLE input: 35 output: 14 [list of 2’s: 2, 12, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 32]
*/
public class CountNoOfP {
    public void Compute(){
        int p=100; int n=120;
        if(n < 10){
            System.out.println(1);
            return;
        }
        int count = 1;
        count = count + (n/100);
        if(n/100 > p)
            count = count + 9;
        int l = n % 100;
        if(n % 100 > p )
            count ++ ;
        System.out.println(count);
    }
}
