package LinkedList;

/**
 * Created by amritachowdhury on 5/27/17.
 */
public class coding_2_2 {
    SingleLinkedList ll = new SingleLinkedList();

    public void run() {
        int k = 7;
        createLinkedList();
        print();
        System.out.println();
        printKth(ll.head, k);
    }

    private void createLinkedList() {
        ll.appendNode(3); ll.appendNode(5); ll.appendNode(6); ll.appendNode(1);
        ll.appendNode(5); ll.appendNode(3); ll.appendNode(0); ll.appendNode(3);
        ll.appendNode(4);
    }

    private void print() {
        try {
            ll.printLinkedList();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private int printKth(Node n, int k) {
        if (n == null) {
            return 0;
        }
        int counter = printKth(n.next, k);
        counter ++;
        if (counter == k) {
            System.out.print(n.data);
        }
        return counter;
    }
}
