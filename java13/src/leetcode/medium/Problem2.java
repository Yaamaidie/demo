package leetcode.medium;

import leetcode.ListNode;

/**
 * 任意长度的数用链表表示时，加法的实现（当前支持10进制）。
 *
 * @author 李俊
 */
public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int extra = 0;
        ListNode preHead = new ListNode(0), p = preHead;
        while (l1 != null || l2 != null || extra != 0) {
            if (l1 != null) {
                extra += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                extra += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(extra % 10);
            p = p.next;//更新当前节点
            extra /= 10;
        }

        return preHead.next;
    }

    public static void main(String[] args) {
        Problem2 main = new Problem2();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(5))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(main.addTwoNumbers(l1, l2));
        l1 = new ListNode(5);
        l2 = new ListNode(5);
        System.out.println(main.addTwoNumbers(l1, l2));
        l1 = new ListNode(1);
        l2 = new ListNode(9, new ListNode(9));
        System.out.println(main.addTwoNumbers(l1, l2));
    }
}
