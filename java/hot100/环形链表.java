package hot100;

/**
 * 将链表指针反转解决
 * 较优思路：快慢指针，如果存在环，那么快慢指针一定会相遇
 */
public class 环形链表 {
      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != null) {
            if (curr==head) return true;
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return false;
    }
}
