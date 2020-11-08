package TopInterviewQuestions.Medium.LinkedList;

public class OddEvenLinkedList {
    ListNode head;
    public static void main(String[] args) {
        OddEvenLinkedList ol = new OddEvenLinkedList();
        ol.insert();
        System.out.println(ol.oddEvenList(ol.head));
    }

    public ListNode insert(){
        head = new ListNode(1);
        ListNode sec = new ListNode(2);
        ListNode thi = new ListNode(3);
        ListNode fou = new ListNode(4);
        ListNode fiv = new ListNode(5);
        head.next=sec;
        sec.next=thi;
        thi.next=fou;
        fou.next =fiv;
        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyCur = dummy;
        ListNode current = head;
        while(current.next!=null){
            dummy.next = new ListNode(current.next.val);
            current.next = current.next.next;
            current = current.next;
            dummy = dummy.next;
        }
        current.next = dummyCur.next;
        return head;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        next = null;
    }
}
