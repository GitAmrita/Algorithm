import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by achowdhury on 6/11/2015.
 */
//Implement an algorithm to find the nth to last element of a singly linked list.
// Write code to remove duplicates from an unsorted linked list.
public class LinkedListQ1 {
    public class Node {
        int data;
        Node next;
        Node(int i){
            data = i;
            next = null;
        }
        //to account for circular linked list
        Node(int i, Node n){
            data = i;
            next = n;
        }
    }

    public class List{
        Node head = null;

        public void AddToEnd(int value){
            if(head == null){
                head = new Node (value); //creating the very first node in the list
                return ;
            }
            Node temp = head;
            while(temp.next != null){
                temp = temp.next ;
            }
            temp.next = new Node(value);
        }
        //Implement an algorithm to find the nth to last element of a singly linked list.
        public void DisplayList(int startFrom){
            if(head == null)
                return ;
            Node temp = head;
            int count =0 ;
            while (temp != null){
                count ++ ;
                if(count >= startFrom){
                    System.out.println(temp.data);
                }
                temp = temp.next ;
            }
        }

        // Write code to remove duplicates from an unsorted linked list.
        public void RemoveDupes(){
            if(head == null)
                return ;
            Node temp = head ;
            Map<Integer, Integer> unique = new HashMap<Integer, Integer>();
            unique.put(head.data,1);
            while(temp.next != null){
                //this is dupe
                if(unique.get(temp.next.data) != null){
                    temp.next = temp.next.next ;
                }
                else {
                    unique.put(temp.next.data,1);
                    temp = temp.next;
                }
            }
        }

      /* Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
        DEFINITION Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node
        , so as to make a loop in the linked list. EXAMPLE: input: A -> B -> C -> D -> E -> C [the same C as earlier] output: C*/

        public void FindFaultyNode(){
            if(head == null)
                return;
            Node temp = head;
            Map<Integer, Integer> unique = new HashMap<Integer, Integer>();
            while(temp != null){
                if(unique.get(temp.data) != null){
                    System.out.println(temp.data);
                    break;
                }
                unique.put(temp.data,1);
                temp = temp.next ;
            }
        }

        public void Sum(List l1, List l2){

        }
    }

    public void CallFunction(){
        List obj=new List();
        obj.AddToEnd(1);
        obj.AddToEnd(2);
        obj.AddToEnd(3);
        obj.AddToEnd(4);
        obj.AddToEnd(5);
        obj.AddToEnd(3);
        obj.FindFaultyNode();
        obj.RemoveDupes();
        obj.DisplayList(1);
    }
}
