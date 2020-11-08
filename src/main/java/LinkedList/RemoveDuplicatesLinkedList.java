package LinkedList;

public class RemoveDuplicatesLinkedList {
    ListNode head = null;
    public static void main(String[] args) {
        RemoveDuplicatesLinkedList in = new RemoveDuplicatesLinkedList();
        in.insert();
        System.out.println(in.deleteDuplicates(in.head));
    }

    private void insert() {
        head = new ListNode(1,null);
        ListNode second = new ListNode(1,null);
        ListNode third = new ListNode(1,null);
        /*ListNode fourth = new ListNode(4,null);
        ListNode fifth = new ListNode(5,null);*/
        head.next = second;
        second.next =third;
       /* third.next = fourth;
        fourth.next =fifth;*/
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev =null;
        ListNode current = head;
        while(current!=null){
            if(prev!=null && prev.val == current.val){
                ListNode tmpNode = current;
                prev.next = tmpNode.next;
            }
            prev = current;
            current = current.next;
        }
        return head;
    }
}
