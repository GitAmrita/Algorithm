/**
 * Created by achowdhury on 7/27/2015.
 */
public class MergeSort3 {

    public void Start(){
        int[] unsorted = new int[]{7,5,3,8,1,9};
        int[] sorted = Divide(unsorted);
        for(int i =0 ; i < sorted.length; i ++)
            System.out.println(sorted[i]);
    }
    public int[] Divide(int[] arr){
        if(arr.length == 1)
            return arr ;
        int length = arr.length / 2;
        int[] arrL = new int[length];
        int [] arrR ;
        //arr.length is even
        if(arr.length % 2 == 0)
            arrR = new int[length];
        else{
            arrR = new int[length + 1];
            //insert the last element in the right array since right will have 1 more than left
            arrR[arrR.length - 1] = arr[arr.length - 1];
        }

        for(int i = 0; i < length ; i++)   {
            arrL[i] = arr[i];
            arrR[i] = arr[i + length];
        }
        arrL = Divide(arrL);
        arrR = Divide(arrR);
        return  Merge(arrL,arrR);
    }
    public int[] Merge(int[]left, int[]right){
        int l = 0 ; int r = 0; int i = 0;
        int[]sorted = new int[left.length + right.length];
        while(l < left.length && r < right.length){
            if(left[l] < right[r]){
                sorted[i] = left[l];
                l++;
            }
            else{
                sorted[i] = right[r];
                r++;
            }
            i++;
        }
        if(l < left.length)
        {
            while(l < left.length){
                sorted[i] = left[l];
                i ++ ; l ++;
            }
        }
        else//(r < right.length)
        {
            while(r < right.length){
                sorted[i] = right[r];
                i ++ ; r ++;
            }
        }
        return sorted;
    }
}
