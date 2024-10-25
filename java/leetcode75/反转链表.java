package leetcode75;

public class 反转链表 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        反转链表 solution = new 反转链表();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);

        System.out.println("Original list:");
        solution.printList(head);

        // Reverse the linked list
        ListNode reversedHead = solution.reverseList(head);

        System.out.println("Reversed list:");
        solution.printList(reversedHead);
    }
    // Helper method to print the list
    private void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode q=head;ListNode p=head;
        while(q!=null){
            if(q==head){
                q=q.next;
                p.next=null;

            }
            else {
                ListNode temp=q.next;
                q.next=p;
                p=q;
                q=temp;
            }

        }
        head=p;
        return head;
    }
}
