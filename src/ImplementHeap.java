/**
 * Created by achowdhury on 6/13/2015.
 */
public class ImplementHeap {
    public int[] heap = new int [12];
    int filled = -1;

    public void InsertValue(int num){
        filled ++ ;
        heap[filled]=num;
        if(filled == 0)//this is the first element
            return;
        int parent = GetParent(filled);
        if(heap[parent] <= heap[filled])//heap property is maintained after insert
            return;
        BubbleUp(filled);//maintain the heap property after the insert
    }

    public void ExtractMin(){
        System.out.println("Min is : " + heap[0]);
        heap[0]=heap[filled];
        heap[filled]=10000;
        filled --;
        BubbleDown(0);
    }

    public void BubbleDown(int parent){
        while(true){
            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2;
            if(heap[leftChild] > heap[parent] && heap[rightChild] > heap[parent])//heap property restored
                break;
            if(leftChild > filled && rightChild> filled)//denotes leaf node
                break;
            int swapChild = SwapChild(heap[leftChild],heap[rightChild],leftChild,rightChild);
            Swap(parent,swapChild);
            parent = swapChild;
        }
    }

    public int SwapChild(int leftChild, int rightChild, int leftNode, int rightNode){
        if(leftChild < rightChild)
            return leftNode;
        else
            return rightNode;
    }

    public void BubbleUp(int child){
        while(child >0){//child = 0 is the root parent
            int parent = GetParent(child);
            if(heap[parent] <= heap[child])//heap property is maintained after last \bubble up
                return;
            Swap(child, parent);// swap to maintain heap property and keep checking the previous parents
            child = parent;
        }
    }

    public int GetParent(int child){
        int parent;
        if(IsEven(child))
            parent =child/2 -1 ;
        else
            parent = (int)Math.floor((double)child/2);
        return parent;
    }

    public void Swap(int child, int parent){
        int temp = heap[child] ;
        heap[child]=heap[parent];
        heap[parent]=temp;
    }

    public Boolean IsEven(int num){
        if(num % 2 == 0)
            return true;
        else
            return false;
    }

    public void DisplayHeap(){
        for(int i = 0; i < filled ; i++){
            int parent = heap[i];
            int leftNode = 2*i + 1;
            int rightNode = 2*i + 2;
            int leftChild = -99;
            int rightChild =-99;
            if(leftNode <= filled)
             leftChild = heap[leftNode];
            if(rightNode <= filled)
             rightChild = heap[rightNode];
            System.out.println(parent + " : " + leftChild + " , " + rightChild);
        }
    }

    public void CreateHeap(){
        InsertValue(4);
        InsertValue(4);
        InsertValue(8);
        InsertValue(9);
        InsertValue(4);
        InsertValue(12);
        InsertValue(9);
        InsertValue(11);
        InsertValue(13);
        InsertValue(7);
        InsertValue(10);
        InsertValue(5);
        ExtractMin();
        DisplayHeap();
    }
}
