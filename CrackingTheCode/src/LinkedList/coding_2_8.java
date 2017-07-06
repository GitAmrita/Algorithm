package LinkedList;

/**
 * Created by amritachowdhury on 5/29/17.
 */
public class coding_2_8 {
    SingleLinkedList ll = new SingleLinkedList();

    public void run() {
        createLinkedList();
        System.out.println();
        Node loopStart = getLoopStart();
        if (loopStart == null) {
            System.out.println("No loop present");
        } else {
            System.out.println(loopStart.data);
        }
    }

    private Node getLoopStart() {
        Node slow = ll.head; Node fast =  ll.head;
        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null; // no loop detected
        }
        slow = ll.head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    private void createLinkedList() {
        Node n4 = new Node(4); Node n11 = new Node(11);
        ll.appendNode(1); ll.appendNode(2); ll.appendNode(3); ll.appendNode(n4);
        ll.appendNode(5); ll.appendNode(6); ll.appendNode(7); ll.appendNode(8);
        ll.appendNode(9); ll.appendNode(10); ll.appendNode(n11); ll.extendList(n11, n4);
    }

    private void print() {
        try {
            ll.printLinkedList();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
