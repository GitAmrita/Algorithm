/**
 * Created by achowdhury on 5/29/2015.
 */
public class LinkedList {
    public static class Node
    {
        public int value;
        public Node next;

        public Node(int val){value = val;}
    }
    public static class List{
        public Node head = null;

        public void AddSorted(int i)
        {
            //this is the first element
            if(head == null)
            {
                head = new Node(i);
                return;
            }
            //new element is the smallest element added to the beginning of the list
            if(head.value > i)
            {
                Node newNode= new Node(i);
                newNode.next  = head;
                head = newNode;
                return;
            }
            Node temp = head ;
            while(temp.next != null)
            {
                if(temp.next.value <= i)
                {
                    temp=temp.next;
                }
                else
                {
                    Node newNode= new Node(i);
                    newNode.next  = temp.next;
                    temp.next = newNode ;
                    return ;
                }
            }
            //new element is the largest element and is added at the end of the list
            if(temp.next == null)
            {
                temp.next = new Node(i);
            }
        }

        public void Display()
        {
            Node temp = head ;
            while(temp != null)
            {
                System.out.println(temp.value);
                temp = temp.next ;
            }
            System.out.println("************");
        }
    }
    public void CallLinkedList()
    {
        List lst = new List ();
        lst.AddSorted(1);
        lst.Display();
        lst.AddSorted(2);
        lst.Display();
        lst.AddSorted(5);
        lst.Display();
        lst.AddSorted(8);
        lst.Display();
        lst.AddSorted(3);
        lst.Display();
        lst.AddSorted(0);
        lst.Display();
        lst.AddSorted(10);
        lst.Display();
    }

}
