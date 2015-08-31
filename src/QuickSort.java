/**
 * Created by achowdhury on 5/16/2015.
 */
public class QuickSort {
    public void CallSortQuick ()
    {
        QuickSort ms=new QuickSort();
        int unsortedArray[]=new int [] {9,8,7,6};
        int sortedArray[]=ms.QuickSort(unsortedArray,1,unsortedArray.length);
        for(int i = 0 ; i < sortedArray.length ; i++)
        {
            System.out.println(sortedArray[i]);
        }
    }
    private int[] QuickSort(int array[], int low, int high)
    {
        if(low < high)
        {
            int pivotLocation = Partition(array, low,high);
            QuickSort(array,low,pivotLocation - 1);
            QuickSort(array,pivotLocation + 1,high);
        }
        return array ;
    }

    private int Partition(int array[],int low,int high)
    {
        int pivot = array[low-1] ;
        int leftWall = low ;
        for(int i = low  ; i < high ; i ++)
        {
            if(array[i] < pivot)
            {
                int temp = array[i];
                array[i]=array[leftWall];
                array[leftWall] = temp ;
                leftWall = leftWall + 1;
            }
        }
        array[low-1] = array[leftWall-1];
        array[leftWall-1] = pivot ;
        return leftWall;
    }

}
