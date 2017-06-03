package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amritachowdhury on 5/29/17.
 */
public class coding_2_7 {
    SingleLinkedList list1 = new SingleLinkedList();
    SingleLinkedList list2 = new SingleLinkedList();

    public void run() {
        createLinkedList();
        print(list1);
        System.out.println();
        print(list2);
        System.out.println();
        Node intersectingNode = findIntersectingNode(list1.head, list2.head);
        if (intersectingNode == null) {
            System.out.println("No intersection");
        } else {
            System.out.println(intersectingNode.data);
        }
    }

    private Node findIntersectingNode(Node head1, Node head2) {
        Set<Node> nodeSet = new HashSet<>();
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            } else if (nodeSet.contains(head1)) {
                return head1;
            } else if (nodeSet.contains(head2)) {
                return head2;
            } else {
                nodeSet.add(head1);
                nodeSet.add(head2);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return null;
    }

    private void createLinkedList() {
        Node n1 = new Node(1); Node n5 = new Node(5); Node n3 = new Node(3); Node n2 = new Node(2);
        Node n6 = new Node(6);
        Node n4 = new Node(4);  Node n7 = new Node(7); Node n20 = new Node(20);
        list1.appendNode(n1); list1.appendNode(n5); list1.appendNode(n3); list1.appendNode(n2);
        list1.appendNode(n6);
        list2.appendNode(n20); list2.appendNode(n7); list2.appendNode(n4);
        list2.extendList(n4, n3);
    }

    private void print(SingleLinkedList ll) {
        try {
            ll.printLinkedList();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
