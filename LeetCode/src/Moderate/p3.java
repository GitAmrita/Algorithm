package Moderate;

/**
 * Created by amritachowdhury on 7/15/17.
 */
public class p3 {

    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowPointer = head; ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            int count = 0;
            while (count < n) {
                fastPointer = fastPointer.next;
                count++;
            }
            slowPointer = slowPointer.next;
        }
        if (slowPointer.next != null) {
            slowPointer.next = slowPointer.next.next;
        }
        return head;
    }
}
