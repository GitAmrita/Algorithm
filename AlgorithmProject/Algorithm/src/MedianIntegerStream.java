import java.util.PriorityQueue;

/**
 * Created by achowdhury on 6/13/2015.
 */
public class MedianIntegerStream {

    public PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
    public PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    int numOfElements =0;

    public void AddNos(int num){
        maxHeap.add(ReturnInverted(num));//first of all just add to max heap
        if(IsEven(numOfElements)){// the heaps are balanced
            if(minHeap.isEmpty()){//this is the first element so no need for any comparisons
                numOfElements ++ ;
                return ;
            }
            else{// this is not the first element so making the rootMax < rootMin
                if(ReturnInverted(maxHeap.peek())> minHeap.peek()){
                    int rootMax = ReturnInverted(maxHeap.poll());
                    int rootMin = minHeap.poll();
                    maxHeap.add(ReturnInverted(rootMin));
                    minHeap.add(rootMax);
                }
            }
            numOfElements ++;
        }
        else{// to balance the heaps
            minHeap.add(ReturnInverted(maxHeap.poll()));
            numOfElements ++;
        }
    }
    public void GetMedian(){
        float median;
        if(IsEven(numOfElements)){
            median=((float)ReturnInverted(maxHeap.peek()) + (float)minHeap.peek())/2;
        }
        else median = ReturnInverted(maxHeap.peek());
        System.out.println(median);
    }
    //this is a cheating. instead of implementing a comparator for max heap just negate the numbers to get max
    public int ReturnInverted(int num){
        return num * -1 ;
    }

    public Boolean IsEven(int num){
        if(num % 2 == 0)
            return true;
        else return false;
    }

    public void CallMedian(){
        AddNos(1);
        GetMedian(); // should be 1
        AddNos(5);
        AddNos(10);
        AddNos(12);
        AddNos(2);
        GetMedian(); // should be 5
        AddNos(3);
        AddNos(8);
        AddNos(9);
        GetMedian(); // should be 6.5
    }
}
