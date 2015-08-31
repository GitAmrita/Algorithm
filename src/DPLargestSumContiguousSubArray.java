/**
 * Created by achowdhury on 6/28/2015.
 */
public class DPLargestSumContiguousSubArray {
    public int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};

    public int GetSum(){
        int curr_max = a[0];
        int final_max = a[0];
        for(int i = 1; i < a.length ; i++){
            curr_max = GetMax(a[i], curr_max + a[i]) ;
            final_max = GetMax(curr_max,final_max);
        }
        return final_max;
    }

    public int GetMax(int a, int b){
        return(a> b ? a : b);
    }

    public void CalculateLargestSum(){
        System.out.println(GetSum());
    }
}
