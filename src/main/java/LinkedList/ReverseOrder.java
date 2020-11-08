package LinkedList;

import java.util.List;

public class ReverseOrder {
    ListNode head;

    public static void main(String[] args) {
        ReverseOrder ro = new ReverseOrder();
        ro.insert();
        ro.reorder();
    }

    public ListNode reorder(){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast= dummy;
        ListNode index=dummy;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast= fast.next.next;
        }
        if(fast!=null){
            prev=slow;
            slow=slow.next;
        }
        prev.next = null;
        ListNode reversed = reverse(slow);
        ListNode node = combine(index.next,reversed);
        return node;
    }

    private ListNode combine(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(0);
        ListNode runner= prehead;
        while(l1!=null && l2!=null){
            runner.next = l1;
            l1= l1.next;
            runner.next.next = l2;
            l2= l2.next;
            runner= runner.next.next;
        }
        runner.next = l1==null?l1:l2;
        return prehead.next;
    }

    public ListNode reverse(ListNode slow){
        ListNode cur = slow;
        ListNode prev = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev=cur;
            cur= next;
        }
        return prev;
    }



    private void insert() {
        head = new ListNode(1,null);
        ListNode second = new ListNode(2,null);
        ListNode third = new ListNode(3,null);
        ListNode fourth = new ListNode(4,null);
        ListNode five = new ListNode(5,null);
        head.next = second;
        second.next =third;
        third.next = fourth;
        fourth.next =five;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
