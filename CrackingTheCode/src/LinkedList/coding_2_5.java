package LinkedList;

/**
 * Created by amritachowdhury on 5/29/17.
 */
public class coding_2_5 {
    SingleLinkedList list1 = new SingleLinkedList();
    SingleLinkedList list2 = new SingleLinkedList();
    SingleLinkedList sumList = new SingleLinkedList();

    SingleLinkedList list1Forward = new SingleLinkedList();
    SingleLinkedList list2Forward = new SingleLinkedList();
    SingleLinkedList sumListForward = new SingleLinkedList();

    public void run() {
        // reversed list - easy case
        printSumReverseList();
        System.out.println();
        System.out.println();
        printSumForwardList();
    }

    private void printSumReverseList() {
        createLinkedList(list1, new int [] {9, 7, 8}) ;
        print(list1);
        System.out.println();
        createLinkedList(list2, new int [] {6, 8, 5}) ;
        print(list2);
        computeReverseSum(list1.head, list2.head);
        System.out.println();
        print(sumList);
    }

    private void printSumForwardList() {
        createLinkedList(list1Forward, new int [] {6, 1, 7}) ;
        print(list1Forward);
        System.out.println();
        createLinkedList(list2Forward, new int [] {2, 9, 5}) ;
        print(list2Forward);
        Node node1Reversed = reverseList(list1Forward, list1Forward.head, null);
        Node node2Reversed = reverseList(list2Forward, list2Forward.head, null);
        computeForwardSum(node1Reversed, node2Reversed);
        System.out.println();
        print(sumListForward);
    }

    private Node reverseList(SingleLinkedList ll, Node current, Node previous) {
        if (current.next == null) {
            ll.head = current;
            current.next = previous;
            return null;
        }
        Node next1 = current.next;
        current.next = previous;
        reverseList(ll, next1, current);
        return ll.head;
    }

    private void computeForwardSum(Node node1, Node node2) {
        int carry = 0; int sum;
        while (node1 != null && node2 != null) {
            int s = node1.data + node2.data + carry;
            carry = s / 10;
            sum = s % 10;
            appendAtBeginning(sumListForward, sum);
            node1 = node1.next; node2 = node2.next;
        }
        Node remainingNode = node1 == null ? node2 : node1;
        while (remainingNode != null) {
            int s = remainingNode.data + carry;
            carry = s / 10;
            sum = s % 10;
            appendAtBeginning(sumListForward, sum);
            remainingNode = remainingNode.next;
        }
        if (carry != 0) {
            appendAtBeginning(sumListForward, carry);
        }
    }

    private void appendAtBeginning(SingleLinkedList list, int data) {
        if (list.head == null) {
            list.head = new Node (data);
        } else {
            Node n =  new Node (data);
            n.next = list.head;
            list.head = n;
        }
    }

    private void computeReverseSum(Node node1, Node node2) {
        int carry = 0; int sum;
        while (node1 != null && node2 != null) {
            int s = node1.data + node2.data + carry;
            carry = s / 10;
            sum = s % 10;
            createLinkedList(sumList, sum);
            node1 = node1.next; node2 = node2.next;
        }
        Node remainingNode = node1 == null ? node2 : node1;
        while (remainingNode != null) {
            int s = remainingNode.data + carry;
            carry = s / 10;
            sum = s % 10;
            createLinkedList(sumList, sum);
            remainingNode = remainingNode.next;
        }
        if (carry != 0) {
            createLinkedList(sumList, carry);
        }
    }

    private void createLinkedList(SingleLinkedList ll, int [] data) {
        for (int i = 0; i < data.length; i++) {
            ll.appendNode(data[i]);
        }

    }

    private void createLinkedList(SingleLinkedList ll, int data) {
        ll.appendNode(data);
    }

    private void print(SingleLinkedList ll) {
        try {
            ll.printLinkedList();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
