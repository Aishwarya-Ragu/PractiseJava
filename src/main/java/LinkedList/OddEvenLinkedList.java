package LinkedList;

public class OddEvenLinkedList {
    ListNode head = null;
    public static void main(String[] args) {
        OddEvenLinkedList in = new OddEvenLinkedList();
        in.insert();
        System.out.println(in.oddEvenList(in.head));
    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode first = head;
        ListNode second =null;
        if(head.next!=null){
            second = head.next;
        }
        ListNode evenHead = second;
        while(first.next!=null && first.next.next!=null){
            first.next = first.next.next;
            first = first.next;
        }
        while(second.next!=null && second.next.next!=null){
            second.next = second.next.next;
            second = second.next;
        }
        first.next = evenHead;

        return head;
    }



    private void insert() {
        head = new ListNode(1,null);
        ListNode second = new ListNode(2,null);
        ListNode third = new ListNode(3,null);
        ListNode fourth = new ListNode(4,null);
        ListNode fifth = new ListNode(5,null);

        head.next = second;
        second.next =third;
        third.next = fourth;
        fourth.next =fifth;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
