package hot100;

public class 两两交换链表中的节点 {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0,head);
        ListNode ans=dummy;
        ListNode p=head;
        while (p!=null&&p.next!=null){
            ListNode temp=p.next;
            p.next=temp.next;
            dummy.next=temp;
            temp.next=p;
            dummy=dummy.next.next;
            p=p.next;
        }
        return ans.next;
    }
}
