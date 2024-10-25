package leetcode75;

public class 链表最大孪生和 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public int pairSum(ListNode head) {
          ListNode slow = head;
          ListNode fast = head;
          while (fast != null && fast.next != null) {
              slow = slow.next;
              fast = fast.next.next;
          }
        ListNode secondnode = reverse(slow);
          int sum = 0;slow=head;
          while (secondnode != null) {
              sum = Math.max(sum, secondnode.val + slow.val);
              slow = slow.next;
              secondnode = secondnode.next;
          }
          return sum;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
