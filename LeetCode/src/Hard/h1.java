package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by amritachowdhury on 7/17/17.
 */
public class h1 {

     public class ListNode implements Comparator {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

         @Override
         public int compare(Object l1, Object l2) {
             return ((ListNode)l1).val - ((ListNode)l2).val;
         }
     }

     public void run() {
         ListNode[] lists = new ListNode[2];
         ListNode head = new ListNode(0);
         ListNode l = head;
         l.next = new ListNode(7);
         l = l.next;
         l.next = new ListNode(19);
         lists[0] = head;

         ListNode head1 = new ListNode(5);
         ListNode l1 = head1;
         l1.next = new ListNode(11);
         l1 = l1.next;
         l1.next = new ListNode(51);
         lists[1] = head1;
         mergeKLists(lists);

     }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode sortedHead = null; ListNode temp = null;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode n : lists) {
            while (n != null) {
                queue.offer(n.val);
                n = n.next;
            }
        }
        while(!queue.isEmpty()) {
            if (sortedHead == null) {
                sortedHead = new ListNode(queue.poll());
                temp = sortedHead;
            } else {
                temp.next = new ListNode(queue.poll());
                temp = temp.next;
            }
        }
        return sortedHead;
    }
}
