package LinkedList;

import java.util.List;

public class RemoveNThNode {
    ListNode head = null;
    public static void main(String[] args) {
        RemoveNThNode in = new RemoveNThNode();
        in.insert();
        System.out.println(in.removeNthFromEnd(in.head,1));
    }


    private void insert() {
        head = new ListNode(3,null);
        /*ListNode second = new ListNode(2,null);
        ListNode third = new ListNode(0,null);
        ListNode fourth = new ListNode(4,null);
        head.next = second;
        second.next =third;
        third.next = fourth*/;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstPtr = dummy;
        ListNode secondPtr =dummy;
        while(n+1!=0){
            firstPtr = firstPtr.next;
            n--;
        }
        while(firstPtr!=null){
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }
        secondPtr.next = secondPtr.next.next;

        return dummy.next;

    }

}
