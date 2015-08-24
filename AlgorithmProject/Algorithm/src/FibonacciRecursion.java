/**
 * Created by achowdhury on 5/17/2015.
 */
public class FibonacciRecursion {
    public void FibonacciRecursion (){
        //0,1,1,2,3,5.....
        FibonacciRecursion fR=new FibonacciRecursion();
        int series[] = new int[10] ;
        for(int i =0 ; i <  series.length ; i++)
        {
            series[i]=fR.Fibonacci(i);
            System.out.println(series[i]);
        }
    }
    private int Fibonacci(int n)
    {
        if(n == 0)
            return 0;
        if( n == 1)
            return 1;
        else
            return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
