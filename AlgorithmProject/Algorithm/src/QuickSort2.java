/**
 * Created by achowdhury on 6/19/2015.
 */
public class QuickSort2 {
    int[] unsorted =new int[]{28,16,30,7,4,5,9};
    public void CallQuick(){
        Partition(0,unsorted.length - 1);
        PrintArray();
    }

    public void Partition(int low, int high){
        if(low < high){
            int wall = low + 1;
            int pivot = unsorted[low];
            for(int i = low + 1; i<= high; i++){
                if(unsorted[i]< pivot){
                    Swap(wall,i);
                    wall ++;
                }
            }
            Swap(low,wall-1);
            PrintArray();
            Partition(low, wall-1);
            Partition(wall,high);
        }
    }
    public void Swap(int i1, int i2){
        if(i1 == i2)
            return;
        int temp = unsorted[i1];
        unsorted[i1] = unsorted[i2];
        unsorted[i2] = temp;
    }

    public void PrintArray(){
        for(int i = 0; i < unsorted.length ; i++){
            System.out.print(unsorted[i] + "->");
        }
        System.out.println();
    }
}
