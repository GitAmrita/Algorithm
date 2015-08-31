/**
 * Created by achowdhury on 5/17/2015.
 */
public class FibonacciIteration {
    public void Fibonacci (){
        //0,1,1,2,3,5.....
        int series[] = new int[10] ;
        for(int i =0 ; i <  series.length ; i++)
        {
            if( i == 0 || i == 1)
                series[i]= i;
            else
                series[i] = series[i-1] + series[i-2] ;
            System.out.println(series[i]);
        }
    }
}
