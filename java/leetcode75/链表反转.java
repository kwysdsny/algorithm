package leetcode75;

public class 链表反转 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 链表反转迭代法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next; // 保存下一个节点
            current.next = prev; // 反转当前节点指针
            prev = current; // 移动 prev 到当前节点
            current = nextTemp; // 移动到下一个节点
        }

        return prev; // 返回新的头节点
    }

    /**
     * 链表反转递归法(太抽象了)
     * @param head
     * @return
     */

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head; // 基本情况
        }

        ListNode newHead = reverseListRecursive(head.next); // 递归反转后续节点
        head.next.next = head; // 反转当前节点
        head.next = null; // 断开与后续节点的连接

        return newHead; // 返回新的头节点
    }

}
