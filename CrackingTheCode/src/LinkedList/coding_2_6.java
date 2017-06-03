package LinkedList;

import java.util.Stack;

/**
 * Created by amritachowdhury on 5/29/17.
 */
public class coding_2_6 {
    SingleLinkedList ll = new SingleLinkedList();

    public void run() {
        createLinkedList();
        print();
        boolean palindrome = isAPalindrome();
        System.out.println();
        System.out.println(palindrome);
    }

    private boolean isAPalindrome() {
        Node n = ll.head;
        Stack<Node> stack = new Stack<>();
        while (n.next != null) {
            stack.add(n);
            n = n.next;
        }
        stack.add(n);
        n = ll.head;
        while (!stack.empty()) {
            Node reversed = stack.pop();
            if (reversed.data != n.data) {
                return false;
            }
            n = n.next;
        }
        return true;
    }

    private void createLinkedList() {
        Node t = new Node(20); Node a = new Node(1); Node c = new Node(3); Node o = new Node(15);
        Node t1 = new Node(20); Node a1 = new Node(1); Node c1 = new Node(3);
        ll.appendNode(t); ll.appendNode(a); ll.appendNode(c); ll.appendNode(o);
        ll.appendNode(c1); ll.appendNode(a1); ll.appendNode(t1);
    }

    private void print() {
        try {
            ll.printLinkedList();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
