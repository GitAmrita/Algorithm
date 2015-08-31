import java.util.PriorityQueue;

/**
 * Created by achowdhury on 6/18/2015.
 */
public class MicrosoftSortArray {

    //given an array where each element is maximum +- k index away. sort the array

    int[] a= new int[]{5,9,8,7,18,11,15,20};
    int k = 3;
    public void Sort(){
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i= 0; i < a.length ; i++){
            if(i<k)
                heap.add(a[i]);
            else{
                heap.add(a[i]);
                System.out.println(heap.remove());
            }
        }
        while(!heap.isEmpty()){
            System.out.println(heap.remove());
        }
    }
}
