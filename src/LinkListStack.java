/**
 * Created by achowdhury on 7/6/2015.
 */
public class LinkListStack {
    public class Node{
        int value;
        Node next ;
        public Node(int value){
            this.value = value;
            next = null;
        }
    }
    public Node top = null;
    public void Push(int value){
        Node n = new Node(value);
        if(top == null)
        top = n;
        else{
           n.next = top;
            top= n;
        }
    }
    public void Pop(){
        if(top == null)
        {
            System.out.println("stack is empty");
            return;
        }
        System.out.println(top.value);
        top = top.next;
    }
    public void TestStack(){
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
