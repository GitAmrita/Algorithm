package LinkedList;

/**
 * Created by amritachowdhury on 5/27/17.
 */
public class coding_2_3 {
    SingleLinkedList ll = new SingleLinkedList();

    Node n3 = new Node(3); Node n5 = new Node(5); Node n6 = new Node(6);
    Node n1 = new Node(1); Node n0 = new Node(0); Node n4 = new Node(4);

    public void run() {
        Node target = n1;
        createLinkedList();
        print();
        System.out.println();
        deleteNode(target);
        print();

    }

    private boolean deleteNode(Node target) {
        if (target == null || target.next == null) {
            return false;
        }
        target.data = target.next.data;
        target.next = target.next.next;
        return true;
    }

    private void createLinkedList() {
        ll.appendNode(n3); ll.appendNode(n5); ll.appendNode(n6); ll.appendNode(n1);
        ll.appendNode(n0);ll.appendNode(n4);
    }

    private void print() {
        try {
            ll.printLinkedList();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
