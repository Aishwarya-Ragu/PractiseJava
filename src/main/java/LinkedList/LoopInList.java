package LinkedList;

public class LoopInList {
    ListNode head = null;
    public static void main(String[] args) {
        LoopInList in = new LoopInList();
        in.insert();
       System.out.println(in.hasCycle(in.head));
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr!=null && fastPtr.next.next!=null){
            if(slowPtr == fastPtr){
                return true;
            }
            slowPtr =slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return false;

    }

    private void insert() {
        head = new ListNode(3,null);
        /*ListNode second = new ListNode(2,null);
        ListNode third = new ListNode(0,null);
        ListNode fourth = new ListNode(4,null);
        head.next = second;
        second.next =third;
        third.next = fourth;*/
        //fourth.next =second;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
