package LinkedList;

/**
 * Created by amritachowdhury on 5/29/17.
 */
public class coding_2_4 {
    SingleLinkedList ll = new SingleLinkedList();

    public void run() {
        int partition = 5;
        createLinkedList();
        print();
        System.out.println();
        partitionList(ll.head, partition);
        print();

    }

    private void partitionList(Node start, int partition) {
        Node greaterThanPartitionNode = null;
        while (start.next != null) {
            if (start.data >= partition)  {
                if( greaterThanPartitionNode == null) {
                    greaterThanPartitionNode = new Node(start.data);
                } else {
                    Node appendNode = new Node(start.data);
                    appendNode.next = greaterThanPartitionNode;
                    greaterThanPartitionNode = appendNode;
                }
                deleteNode(start);
            } else {
                start = start.next;
            }
        }
        start.next = greaterThanPartitionNode;
    }

    private void deleteNode(Node n) {
        n.data = n.next.data;
        n.next = n.next.next;
    }

    private void createLinkedList() {
        ll.appendNode(10);   ll.appendNode(3); ll.appendNode(5); ll.appendNode(8); ll.appendNode(5);
        ll.appendNode(2); ll.appendNode(1);
    }

    private void print() {
        try {
            ll.printLinkedList();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
