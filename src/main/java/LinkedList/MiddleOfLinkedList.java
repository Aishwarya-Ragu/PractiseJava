package LinkedList;

public class MiddleOfLinkedList {
    ListNode head;
    public static void main(String[] args) {
        MiddleOfLinkedList in = new MiddleOfLinkedList();
        in.insert();
        System.out.println(in.middleNode(in.head));
        System.out.println(in.reverseList(in.head));
    }

    private ListNode reverseList(ListNode head) {
        ListNode current =head;
        ListNode prev = null;
        while(current!=null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev =current;
            current=nextNode;
        }
        return prev;
    }

    private void insert() {
        head = new ListNode(1,null);
        ListNode second = new ListNode(2,null);
        ListNode third = new ListNode(3,null);
        head.next = second;
        second.next =third;
        ListNode four = new ListNode(4,null);
        ListNode five = new ListNode(5,null);
        ListNode six = new ListNode(6,null);
        third.next =four;
        four.next =five;
        five.next = six;
    }

    public ListNode middleNode(ListNode head) {
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        while(secondPointer!=null && secondPointer.next!=null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
        }
        return firstPointer;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
