package LinkedList;

public class AddTwoNumber {
    ListNode firstHead = null;
    ListNode secondHead = null;
    public static void main(String[] args) {
        AddTwoNumber in = new AddTwoNumber();
        in.insert();
        System.out.println(in.addTwoNumbers(in.firstHead,in.secondHead));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode res = null;
        ListNode finalNode = null;
        int rem =0;
        while(head1!=null && head2!=null){
            int val = head1.val+head2.val+rem;
            int msb = val %10;
            ListNode newNode = new ListNode(msb);
            if(res == null){
                res = newNode;
                finalNode = res;
            }else{
                res.next = newNode;
                res = newNode;
            }
            rem = val /10;
            head1 = head1.next;
            head2 = head2.next;
        }
        ListNode remaining = head1!=null? head1:head2!=null?head2:null;

        while (remaining!=null){
            int val = rem+ remaining.val;
            int msb = val %10;
            ListNode newNode = new ListNode(msb);
            if(res == null){
                res = newNode;
                finalNode = res;
            }else{
                res.next = newNode;
                res = newNode;
            }
            rem = val/10;
            remaining = remaining.next;
        }



        return  finalNode;
    }




    private void insert() {
        firstHead = new ListNode(7,null);
        ListNode second = new ListNode(8,null);
        ListNode third = new ListNode(9,null);
        ListNode fourth = new ListNode(1,null);

        firstHead.next = second;
        second.next =third;
        third.next = fourth;

        secondHead = new ListNode(7,null);
        ListNode four = new ListNode(8,null);
        secondHead.next = four;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
