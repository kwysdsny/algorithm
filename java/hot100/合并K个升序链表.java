package hot100;

import java.util.PriorityQueue;


/**
 * 优先队列
 */
public class 合并K个升序链表 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  class status implements Comparable<status> {
      int val;
      ListNode ptr;

      status(int val, ListNode ptr) {
          this.val = val;
          this.ptr = ptr;
      }

      @Override
      public int compareTo(status o) {
          return this.val - o.val;
      }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<status> queue = new PriorityQueue<>();
        for(ListNode node:lists){
            if(node!=null){
                queue.add(new status(node.val,node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!queue.isEmpty()){
            status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if(f.ptr.next!=null){
                queue.add(new status(f.ptr.next.val,f.ptr.next));
            }
        }
        return head.next;
    }
}
