package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amritachowdhury on 5/27/17.
 */
public class coding_2_1 {
    SingleLinkedList ll = new SingleLinkedList();

     public void run() {
         createLinkedList();
         print();
         removeDuplicates();
         System.out.println();
         print();
     }

     private void removeDuplicates() {
         Node slow = null; Node fast = ll.head;
         Set<Integer> holder = new HashSet<>();
         while (fast != null) {
             if (holder.contains(fast.data)) {
                 slow.next = fast.next;
             } else {
                 holder.add(fast.data);
                 slow = fast;
             }
             fast = fast.next;
         }
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
}
