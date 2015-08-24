/**
 * Created by achowdhury on 6/22/2015.
 */
public class MergeSort2 {
    public void CallMergeSort(){
        int[] unsorted = new int[]{7,5,3,8,1,9};
        int[] sorted= MergeSort(unsorted);
        for(int i=0; i< sorted.length; i++){
            System.out.println(sorted[i]);
        }
    }

    public int[] MergeSort(int[] unsorted){
        int eachLength = unsorted.length/2;
        int [] arrLeft ;
        int [] arrRight ;
        if(unsorted.length<=1)
            return unsorted;
        arrLeft=FillInTwoArrays(unsorted, 0, eachLength -1);
        arrRight=FillInTwoArrays(unsorted, eachLength, unsorted.length-1);
        arrLeft = MergeSort(arrLeft);
        arrRight = MergeSort(arrRight);
        return Merge(arrLeft,arrRight);
    }

    public int[] FillInTwoArrays(int[]unsorted, int low, int high){
        int[] arr = new int [high -low + 1];
        int j = 0;
        for(int i= low; i <= high; i++){
            arr[j]=unsorted[i];
            j++;
        }
        return arr;
    }

    public int[] Merge(int[] r1, int[] r2){
        int iLeft=0;int iRight =0; int iSort=0;
        int [] result = new int[r1.length + r2.length];
        for(int i = 0; i < result.length ; i++){
            if(r1[iLeft]<= r2[iRight]){
                result[i] = r1[iLeft];
                iLeft ++ ;
            }
            else{
                result[i] = r2[iRight];
                iRight ++ ;
            }
            if(iLeft == r1.length || iRight == r2.length){iSort = i;break;}
        }
        while(iLeft < r1.length){
            result[iSort + 1] = r1[iLeft];
            iSort ++; iLeft ++;
        }
        while(iRight < r2.length){
            result[iSort + 1] = r2[iRight];
            iSort ++; iRight ++;
        }
        return result;
    }
}
