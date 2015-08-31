/**
 * Created by achowdhury on 7/6/2015.
 */
public class ReverseLinkedList {

    public class Node{
        int value;
        Node next;
        Node(int val){
            value = val;
            next = null;
        }
    }
    public Node head = null;
    public void AddLinkedList(int val){
        Node n = new Node(val);
        if(head == null){
            head = n;
            return ;
        }
        n.next = head ;
        head = n;
        return;
    }
    public void ReverseLinkedList(){
        Node currentNode = head ;
        Node prevNode = null;Node  nextNode ;
        while(currentNode != null){
           nextNode = currentNode.next ;
           currentNode.next = prevNode ;
           prevNode = currentNode;
           currentNode = nextNode;
        }
        head = prevNode;
    }
    public void PrintLinkedList(){
        Node temp;
        temp = head ;
        while(temp !=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void CreateLinkedList(){
        AddLinkedList(1);
        AddLinkedList(2);
        AddLinkedList(3);
        AddLinkedList(4);
        AddLinkedList(5);
        PrintLinkedList();
        System.out.println("***********************************");
        ReverseLinkedList();
        PrintLinkedList();
    }
}
