package leetcode.easy;

import leetcode.ListNode;

public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode walkerA = headA;
        ListNode walkerB = headB;

        int count = 0;
        while (count <= 2 && (walkerA != null || walkerB != null)) {
            if (walkerA == null) {
                walkerA = headB;
                count++;
            }
            if (walkerB == null) {
                walkerB = headA;
                count++;
            }
            if (walkerA == walkerB) {
                return walkerA;
            }
            walkerA = walkerA.next;
            walkerB = walkerB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Problem160 main = new Problem160();
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, common));
        ListNode headB = new ListNode(4, new ListNode(0, new ListNode(1, common)));
        System.out.println(main.getIntersectionNode(headA, headB));
    }
}
