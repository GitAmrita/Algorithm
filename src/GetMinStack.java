import java.util.Stack;

/**
 * Created by achowdhury on 7/27/2015.
 */
public class GetMinStack {
    public Stack<Integer> minStack = new Stack<Integer>();
    public Stack<Integer> tempStack = new Stack<Integer>();
    public void InsertIntoStack(){
        int[] a = new int[]{6,5,4,3,2,1};
        for(int i : a){
            if(minStack.isEmpty()){
                minStack.push(i); continue;
            }
             int currMin = minStack.peek();
            if(i < currMin){
                minStack.push(i);
                continue;
            }
            while(minStack.isEmpty() != true && i > minStack.peek())
                tempStack.push(minStack.pop());
            minStack.push(i);
            while(tempStack.isEmpty() != true)
                minStack.push(tempStack.pop());
        }
        GetMin();
    }
    public void GetMin(){
        System.out.println(minStack.pop());
    }
}
