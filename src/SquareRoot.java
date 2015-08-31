/**
 * Created by achowdhury on 6/27/2015.
 */
public class SquareRoot {

    public void GetSquareRoot(){
        int num = 36;
        double t;
        double sqrt = num/ 2 ;
        do{
            t = sqrt ;
            sqrt = (t + num/t)/2;
        }while((t - sqrt) != 0);
        System.out.println(sqrt);
    }
}
