import java.util.Stack;

/**
 * Created by achowdhury on 6/11/2015.
 */

        /*You have two numbers represented by a linked list, where each node contains a single digit.
        Write a function that adds the two numbers and returns the sum as a linked list.
        EXAMPLE:  input: (3 -> 1 -> 5), (5 -> 9 -> 2) output: 9 -> 0 -> 7*/
public class LinkedListSum {

    public class Node{
        public int data;
        public Node next;

        public Node(int val){data = val; next = null;}
    }
    public class List {
        Node head1 = null;
        Node head2 = null;

        public void AddToList1( int value) {
            if(head1 == null){
                head1 = new Node (value); //creating the very first node in the list
                return ;
            }
            Node temp = head1;
            while(temp.next != null){
                temp = temp.next ;
            }
            temp.next = new Node(value);
        }
        public void AddToList2( int value) {
            if(head2 == null){
                head2 = new Node (value); //creating the very first node in the list
                return ;
            }
            Node temp = head2;
            while(temp.next != null){
                temp = temp.next ;
            }
            temp.next = new Node(value);
        }

        public void DoSum(){
            Stack<Integer> s1=new Stack<Integer>();
            Stack<Integer> s2=new Stack<Integer>();
            Stack<Integer> s3=new Stack<Integer>();
            int carry = 0;
            int newAdded = 0;
            Node temp = head1;
            while(temp != null){
                s1.push(temp.data);
                temp = temp.next ;
            }
            temp = head2;
            while(temp != null){
                s2.push(temp.data);
                temp = temp.next ;
            }
            while(! s1.isEmpty() && !s2.isEmpty()){
                int added= s1.pop() + s2.pop() + carry;
                if(added >= 10){
                    newAdded = added % 10 ;
                    carry = added / 10;
                }
                else{
                    newAdded = added;
                    carry = 0;
                }
                s3.push(newAdded);
            }
            while(! s3.isEmpty()){
                System.out.print(s3.pop());
            }
        }
    }

    public void CreateLists(){
        List o= new List();
        o.AddToList1(3);
        o.AddToList1(1);
        o.AddToList1(5);

        o.AddToList2(5);
        o.AddToList2(9);
        o.AddToList2(2);

        o.DoSum();
    }

}
