/**
 * Created by achowdhury on 7/6/2015.
 */
public class LinkListQ {
    public class Node {
        int value;
        Node next;
        Node prev;
        public Node(int val){
            value = val; next  = null; prev = null;
        }
    }
    public Node front = null, rear=null ;

    public void Push(int value){
        Node n = new Node(value);
        //this is the first value
        if(rear ==  null && front == null)
        {
            rear = n;
            front = n;
            return ;
        }
        n.next = rear;
        rear.prev = n;
        rear = n;
    }
    public void Pop(){
        if(front == null){
            System.out.println("queue is empty");
            return ;
        }
        System.out.println(front.value);
        front = front.prev;
    }
    public void TestQ(){
        Pop();
        Push(1);
        Push(2);
        Push(3);
        Push(4);
        Push(5);
        Push(6);
        Pop();
        Pop();
        Pop();
        Pop();
        Pop();
        Pop();
        Pop();
    }
}
