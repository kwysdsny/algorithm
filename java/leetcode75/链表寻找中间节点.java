package leetcode75;

public class 链表寻找中间节点 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 链表寻找中间节点，偶数个节点为中间右边的节点
     * @param head
     * @return
     */
    public ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // 慢指针每次走一步
            fast = fast.next.next; // 快指针每次走两步
        }

        return slow; // 当快指针到达末尾时，慢指针指向的就是中间节点
    }


}
