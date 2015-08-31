/**
 * Created by achowdhury on 8/11/2015.
 */
/*
You are in a room with 100 cups arranged in a big circle. The cups are numbered sequentially from 1 to 100.
At some point in time, cup #1 will be taken away, and cup #2 will be skipped. Then cup #3 will be taken away, and cup #4
will be skipped. This pattern of taking a cup away and skipping the next will keep going around the circle until there is
only one cup left.
Write a program to determine which cup is left.
* */
    /* ASSUMPTIONS :
    1.  WHEN THE GAME STARTS THE CIRCLE ALREADY CONTAINS 100 CUPS
    2.  THE FIRST CUP PICKED IS ALWAYS 1
    3.  CUPS CAN ONLY BE PICKED IN CLOCKWISE MANNER (MEANING 1,3,5,7,...)
    * */
 public class PopSugar {
    public class Node{
        public int value ;
        public Node next ;

        public Node(int val, Node n){value = val; next = n;}
        public Node(int val){value = val; next = null;}
    }
    public Node head = null;
    public void AddACup(){
        // this is the very first cup so numbered 1
        if(head == null){
            head = new Node(1);
            head.next = head;
            return;
        }
        Node temp = head ;
        do{
            temp = temp.next ;
        }while(temp.next != head);
        Node p = new Node(temp.value + 1,head);
        temp.next = p;
    }
    public int PickACup(int cupNo){
        Node temp = head ;
        if(head.next == head){
            return head.value;
        }
        while(temp.next != head){
            if(temp.next.value == cupNo){
                temp.next = temp.next.next;
                return PickACup(temp.next.next.value);
            }
            temp = temp.next;
        }
        temp.next = head.next;
        cupNo = head.next.next.value;
        head = head.next ;
        return PickACup(cupNo);
    }
    public void PrintCircle(){
        Node temp = head ;
        do{
            System.out.println(temp.value);
            temp = temp.next ;
        }while(temp!= head);
    }

    public void StartGame(){
        //Add all the 100 cups at the start of the game
        for(int i = 0; i < 100 ; i++)
            AddACup();
        int answer = PickACup(1);
       System.out.println("The last remaining cup number is : " + answer);
    }
}
