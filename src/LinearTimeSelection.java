/**
 * Created by achowdhury on 5/17/2015.
 */
public class LinearTimeSelection {
    public void LinearSelection ()
    {
        LinearTimeSelection ms=new LinearTimeSelection();
        int unsortedArray[]=new int [] {4,6,1,3,5};
        int sortOrder=ms.FindPivot(unsortedArray,0,unsortedArray.length - 1,1);
        System.out.println(sortOrder);
    }
    private int FindPivot(int array[], int low, int high,int sortOrder )
    {
            if(low == high)
                return array[low];
            int pivotLocation = Partition(array, low,high);
            if(sortOrder == pivotLocation)
                return array[pivotLocation];
            if(sortOrder > pivotLocation)
            {
                return FindPivot(array,pivotLocation + 1, high, sortOrder - (pivotLocation + 1));
            }
            else
            {
                return FindPivot(array, low , pivotLocation - 1 , sortOrder);
            }
    }
    private int Partition(int array[],int low,int high)
    {
        System.out.println("( " + low + " , " + high + ")");
        int pivot = array[low] ;
        int leftWall = low + 1;
        for(int i = low + 1  ; i <= high ; i ++)
        {
            if(array[i] < pivot)
            {
                int temp = array[i];
                array[i]=array[leftWall];
                array[leftWall] = temp ;
                leftWall = leftWall + 1;
            }
        }
        array[low] = array[leftWall - 1];
        array[leftWall - 1] = pivot ;
        return leftWall - 1;
    }
}
