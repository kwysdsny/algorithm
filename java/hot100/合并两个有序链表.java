package hot100;

public class 合并两个有序链表 {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode ptr;
        ListNode res;
        if (ptr1 == null)
            return ptr2;
        else if (ptr2 == null)
            return ptr1;
        else {
            if(ptr1.val <=ptr2.val) {
                ptr=ptr1;
                ptr1=ptr1.next;
            }
            else {
                ptr=ptr2;
                ptr2=ptr2.next;
            }
        }
        res=ptr;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                ptr.next=ptr1;
                ptr1=ptr1.next;
                ptr=ptr.next;
            } else {
                ptr.next=ptr2;
                ptr2=ptr2.next;
                ptr=ptr.next;
            }

        }
        if (ptr1==null){
            ptr.next=ptr2;
        }
        else if (ptr2==null){
            ptr.next=ptr1;
        }
        return res;
    }
}
