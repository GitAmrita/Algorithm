/**
 * Created by achowdhury on 7/11/2015.
 */
public class ExtractMaxHeap {
    int[] a = new int[]{40, 18, 20, 15, 13, 9, 19, 1, 3, 8};
    int filled = a.length - 1;

    private int FindParentNode(int childNode){
        return  childNode % 2 == 0 ? (childNode / 2) -1 : (int)Math.floor(childNode / 2);
    }
    private int FindLeftChildNode(int parentNode){
        return 2 * parentNode + 1;
    }
    private int FindRightChildNode(int parentNode){
        return 2 * parentNode + 2;
    }
    private boolean IsGreater(int leftChildNode, int rightChildNode){
        return a[leftChildNode] >= a[rightChildNode];
    }
    private void Swap(int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private int ExtractMax(){
        int maxValue = a[0];
        a[0] = a[filled];
        filled -- ;
        BubbleDown();
        return maxValue;
    }
    private void BubbleDown(){
        int parent = 0 ;
        while(true){
            int leftChildNode = FindLeftChildNode(parent);
            int rightChildNode = FindRightChildNode(parent);
            if( leftChildNode  > filled && rightChildNode > filled)//leaf node
                break;
            else if(leftChildNode  < filled && rightChildNode > filled){//only left child available
                if(a[parent] < a[leftChildNode])
                    Swap(parent,leftChildNode);
                break;
            }
            else{//both children are present
                int olderChildNode=IsGreater(leftChildNode, rightChildNode)
                        ? leftChildNode : rightChildNode;
                if(a[parent] < a[olderChildNode]){
                    Swap(parent,olderChildNode);
                    parent = olderChildNode;
                }
                else
                    break;
            }
        }
    }
    public void GetMaxValue(){
        System.out.println(ExtractMax());
        System.out.println(ExtractMax());
        System.out.println(ExtractMax());
        System.out.println(ExtractMax());
    }
}
