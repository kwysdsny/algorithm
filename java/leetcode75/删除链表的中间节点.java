package leetcode75;

public class 删除链表的中间节点 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 应该使用快慢指针
     * @param head
     * @return
     */
    public static ListNode deleteMiddle(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        ListNode q=head,t=head;
        int current = 0;
        while (q != null) {
            current++;
            if (current==length/2+1){
                if(current==1){
                    head = null;
                    return head;
                }
                t.next=q.next;
                return head;
            }
            if(q==t){
                q=q.next;
            }
            else {
                q=q.next;
                t=t.next;
            }
        }
        return head;
    }
}
