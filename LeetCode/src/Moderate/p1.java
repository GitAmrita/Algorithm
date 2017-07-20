package Moderate;

import java.util.Stack;

/**
 * Created by amritachowdhury on 7/14/17.
 */
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
* */
public class p1 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }

   public void run() {
        ListNode l1 = new ListNode(2);
        ListNode tail1 = l1;
        tail1.next = new ListNode(4);
        tail1 = tail1.next;
        tail1.next = new ListNode(3);


       ListNode l2 = new ListNode(8);
       ListNode tail2 = l2;
       tail2.next = new ListNode(6);
       tail2 = tail2.next;
       tail2.next = new ListNode(8);

       ListNode result = addTwoNumbers(l1, l2);
       while (result != null) {
           System.out.print(result.val + "-> ");
           result = result.next;
       }

   }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Integer number1 = getInt(l1);
        Integer number2 = getInt(l2);
        Integer result = number1 + number2;
        return getResultList(result);
    }

    private ListNode getResultList(Integer number) {
        ListNode head = null; ListNode tail = null;
        char[] num = number.toString().toCharArray();
        int i = num.length - 1;
        while ( i >= 0) {
            if (head == null) {
                head = new ListNode(Integer.parseInt(String.valueOf(num[i])));
                tail = head;
            } else {
                tail.next = new ListNode(Integer.parseInt(String.valueOf(num[i])));
                tail = tail.next;
            }
            i--;
        }
        return head;
    }

    private int getInt(ListNode l) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while ( l != null) {
            st.push(l.val);
            l = l.next;
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        int number = Integer.parseInt(sb.toString());
        return number;
    }
}
