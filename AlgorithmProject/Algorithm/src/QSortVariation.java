import java.util.Random;

/**
 * Created by achowdhury on 7/18/2015.
 */
public class QSortVariation {
    int k = 4;
    int [] a = new int[] {5,1,4,6,3,2,1};

    public void Swap(int pos1, int pos2){
        int temp = a [pos1];
        a[pos1]= a[pos2] ;
        a[pos2] = temp;
    }

    public void PrintLargest(){
        for(int i = k - 1 ; i < a.length; i++){System.out.println (a[i]);}
    }
    public void Partition(int low, int high){
        if(low < high){
            int pivot = a[low];
            int wall = low + 1;
            for(int i = low + 1 ; i <= high ; i++){
                if(a[i] < pivot){
                    Swap(i,wall);
                    wall ++ ;
                }
            }
            Swap(low, wall - 1);
            //if i want k largest sub array then if pivot is k which means anything right of it is > than pivot.
            //no need to do any more sorting just print those values
            if(wall - 1 == k ){
                PrintLargest();
                return;
            }

            else{
                Partition(0,wall-1);
                Partition(wall, high);
            }
        }
    }
    public void CallQuickSort(){
        Partition(0,a.length - 1);
    }
}
