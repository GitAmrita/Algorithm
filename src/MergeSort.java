/**
 * Created by achowdhury on 5/16/2015.
 */
public class MergeSort {
    public void SortMerge ()
    {
        MergeSort ms=new MergeSort();
        int unsortedArray[]=new int [] {3,2,4,5,1,6,0};
        int sortedArray[]=ms.MergeSort(unsortedArray);
        //print the sorted array
        for(int i = 0 ; i < sortedArray.length ; i++)
        {
            System.out.println(sortedArray[i]);
        }
    }
    private int[] MergeSort(int array[])
    {
        if(array.length <= 1)
            return array;
        int elementsInA1 = array.length/2;
        int elementsInA2 ;
        if(array.length % 2 == 0)
            elementsInA2=elementsInA1;
        else
            elementsInA2 = elementsInA1 + 1;

        int arr1[]=new int[elementsInA1];
        int arr2[]=new int[elementsInA2];

        for(int i=0; i<elementsInA1;i++)
        {
            arr1[i]=array[i];
        }

        for(int i=elementsInA1; i<elementsInA1 + elementsInA2 ;i++)
        {
            arr2[i-elementsInA1]=array[i];
        }
        arr1=MergeSort(arr1);
        arr2=MergeSort(arr2);

        return Merge(arr1,arr2);
    }
    private int[] Merge(int arr1[],int arr2[])
    {
        int iSort = 0;
        int iLeft = 0;
        int iRight = 0 ;
        int sortedArray[]=new int[arr1.length + arr2.length];
        while (iLeft !=  arr1.length && iRight  != arr2.length)
        {
            if(arr1[iLeft] < arr2[iRight])
            {
                sortedArray[iSort]=arr1[iLeft];
                iLeft ++ ;
            }
            else
            {
                sortedArray[iSort]=arr2[iRight];
                iRight ++ ;
            }
            iSort ++ ;
        }
        while (arr1.length  != iLeft)
        {
            sortedArray[iSort]=arr1[iLeft];
            iSort ++ ;
            iLeft ++ ;
        }
        while (arr2.length  != iRight)
        {
            sortedArray[iSort]=arr2[iRight];
            iSort ++;
            iRight ++ ;
        }
        return sortedArray;
    }
}


