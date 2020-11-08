package LinkedList;

public class RemoveElements {
    ListNode head =null;

    public static void main(String[] args) {
        RemoveElements in = new RemoveElements();
        in.insert();
        System.out.println(in.removeElements(in.head,3));
    }

    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val ==val){
            head = head.next;
        }
        ListNode current = head;
        while (current!=null && current.next!=null){
            if(current.next.val == val){
                current.next= current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }


    private void insert() {
        head = new ListNode(3,null);
        ListNode second = new ListNode(2,null);
        /*ListNode third = new ListNode(0,null);
        ListNode fourth = new ListNode(2,null);
        head.next = second;
        second.next =third;
        third.next = fourth;*/
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
