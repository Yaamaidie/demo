package leetcode.easy;

import leetcode.ListNode;

public class Problem141 {
    /**
     * 追赶法
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Problem141 main = new Problem141();

        ListNode head;
        head = new ListNode(1);
        head.next = head;
        System.out.println(main.hasCycle(head));

        head = new ListNode(1);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(3);
        head.next = next1;
        next1.next = next2;
//        next2.next = head;
        System.out.println(main.hasCycle(head));

        head = new ListNode(1);
        System.out.println(main.hasCycle(head));

    }
}
