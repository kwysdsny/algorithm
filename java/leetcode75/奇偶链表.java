package leetcode75;

public class 奇偶链表 {
    public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    /**
     * 这题理解起来有些困难，比较巧妙
     * @param head
     * @return
     */

    public ListNode oddEvenList(ListNode head) {
        // 如果链表为空，直接返回
        if (head == null) {
            return head;
        }

        // 初始化偶数链表头节点
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;

        // 遍历链表，重新排列节点
        while (even != null && even.next != null) {
            odd.next = even.next; // 将当前奇数节点指向下一个奇数节点
            odd = odd.next; // 移动到下一个奇数节点
            even.next = odd.next; // 将当前偶数节点指向下一个偶数节点
            even = even.next; // 移动到下一个偶数节点
        }

        // 将奇数链表的尾部指向偶数链表的头部
        odd.next = evenHead;
        return head; // 返回重新排列后的链表头
    }

}
