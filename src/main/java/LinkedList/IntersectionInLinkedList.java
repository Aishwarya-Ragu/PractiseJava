package LinkedList;

public class IntersectionInLinkedList {
    ListNode firstNode = null;
    ListNode secondNode = null;


    public static void main(String[] args) {
        IntersectionInLinkedList in = new IntersectionInLinkedList();
        in.insert();
        System.out.println(in.getIntersectionNode(in.firstNode,in.secondNode));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lena = length(headA);
        int lenb = length(headB);
        int diff = lena - lenb;
        if(diff == 0){
            ListNode currentA = headA;
            ListNode currentB = headB;
            while(currentA!=null && currentB!=null){
                if(currentA == currentB){
                    return currentA;
                }
                currentA = currentA.next;
                currentB =currentB.next;
            }
        }else if(diff > 0){
            return getIntersection(diff,headA,headB);
        }else{
             return getIntersection(Math.abs(diff),headB,headA);
        }

      return null;
    }

    private ListNode getIntersection(int diff, ListNode firstNode, ListNode secondNode) {
        ListNode currentFirst = firstNode;
        ListNode currentSecond = secondNode;
        while(diff !=0){
            currentFirst =currentFirst.next;
            diff --;
        }
        while(currentFirst!=null && currentSecond!=null){
            if(currentFirst == currentSecond){
                return currentFirst;
            }
            currentFirst =currentFirst.next;
            currentSecond =currentSecond.next;
        }
        return null;
    }

    private int length(ListNode head) {
        ListNode current = head;
        int count =0;
        while(current!=null){
            count++;
            current = current.next;
        }
        return  count;
    }


    private void insert() {
        firstNode = new ListNode(4,null);
        ListNode second = new ListNode(1,null);
        ListNode third = new ListNode(8,null);
        ListNode fourth = new ListNode(4,null);
        ListNode fifth = new ListNode(5,null);
        firstNode.next = second;
        second.next =third;
        third.next = fourth;
        fourth.next =fifth;

        secondNode = new ListNode(5,null);
        ListNode sec = new ListNode(0,null);
        ListNode thi = new ListNode(1,null);


        secondNode.next = sec;
        sec.next =thi;
        thi.next = third;
        third.next =fourth;
        fourth.next = fifth;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
