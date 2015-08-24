import java.util.PriorityQueue;

/**
 * Created by achowdhury on 6/13/2015.
 */
public class HeapSort {

    public PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    public void Sort(int num){
        heap.add(num);
    }
    public void DisplaySorted(){
        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }

    public void AddNos(){
        Sort(2);
        Sort(5);
        Sort(7);
        Sort(-2);
        Sort(-8);
        Sort(0);
        DisplaySorted();
    }
}
