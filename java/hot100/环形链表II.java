package hot100;


/**
 * 快慢指针有环一定相遇,找到环的入口点，数学问题，快慢指针先指向head，直到第一次相遇后，
 * 将fast=head,slow不变，接着fast和slow同时一步一步走，直到第二次相遇就是入口点
 */
public class 环形链表II {
      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
