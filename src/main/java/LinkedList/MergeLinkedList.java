package LinkedList;

public class MergeLinkedList {
    ListNode firstList;
    ListNode secondList;
    ListNode head = null;
    public static void main(String[] args) {
        MergeLinkedList in = new MergeLinkedList();
        in.insert();
        System.out.println(in.mergeTwoLists(in.firstList,in.secondList));
    }

    private void insert() {
        firstList = new ListNode(1,null);
        ListNode second = new ListNode(2,null);
        ListNode third = new ListNode(4,null);
        firstList.next = second;
        second.next =third;
        secondList = new ListNode(0,null);
        ListNode five = new ListNode(3,null);
        ListNode six = new ListNode(4,null);
        secondList.next =five;
        five.next =six;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode current = null;
        if(l1== null){
            return l2;
        }if(l2 == null){
            return l1;
        }
        while(l1 != null && l2 != null ){
            if(l1.val <= l2.val){
                ListNode newNode = new ListNode(l1.val);
                if(head == null){
                    head = newNode;
                    current = head;
                }else{
                    current.next = newNode;
                    current = current.next;
                }
                l1 =l1.next;
            }else if(l2.val <=l1.val){
                ListNode newNode = new ListNode(l2.val);
                if(head == null){
                    head = newNode;
                    current = head;
                }else{
                    current.next = newNode;
                    current = current.next;
                }
                l2 = l2.next;
            }
        }

        if(l1 == null){
            while(l2!=null){
                ListNode newNode = new ListNode(l2.val);
                current.next = newNode;
                current = current.next;
                l2 = l2.next;
            }
        }

        if(l2 == null){
            while(l1!=null){
                ListNode newNode = new ListNode(l1.val);
                current.next = newNode;
                current = current.next;
                l1 = l1.next;
            }
        }

        return head;
    }
}
