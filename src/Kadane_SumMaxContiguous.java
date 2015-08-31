/**
 * Created by achowdhury on 7/9/2015.
 */
public class Kadane_SumMaxContiguous {

    public void FindKadane(){
        int[] a = new int[]{2, 3, -2, -1, 10};
        int currMax = 0;
        int finalMax = 0;
        int lowRange = 0;
        int highRange = 0;
        for(int i = 0 ; i < a.length ; i++){
            currMax = currMax + a[i];
            if(currMax < 0){
                currMax = 0;
                lowRange = i + 1;}

            if(finalMax < currMax){
                highRange = i;
                finalMax = currMax ;}

        }
        System.out.println(lowRange);
        System.out.println(highRange);
        System.out.println(finalMax);
    }
}
