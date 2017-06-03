package LinkedList;

/**
 * Created by amritachowdhury on 5/27/17.
 */
public class SingleLinkedList {
    Node head;

    public SingleLinkedList() {}

    public void appendNode(int data) {
        if ( head == null)  {
            head = new Node(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public void appendNode(Node node) {
        if ( head == null)  {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void extendList(Node n, Node t) {
        n.next = t;
    }

    public void printLinkedList() throws Exception{
        Node temp = head;
        if (temp == null) {
            throw new Exception("Linked list is empty");
        }
        while (temp != null) {
            if (temp.next == null) {
                System.out.print(temp.data );
            } else {
                System.out.print(temp.data + " -> ");
            }
            temp = temp.next;
        }
    }
}
