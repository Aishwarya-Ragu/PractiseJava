package LinkedList;


public class PalindromeLinkedList {
    ListNode head = null;
    public static void main(String[] args) {
        PalindromeLinkedList in = new PalindromeLinkedList();
        in.insert();
        System.out.println(in.isPalindrome(in.head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slowptr = head;
        ListNode fastptr = head;
        while(fastptr!=null && fastptr.next!=null){
            fastptr =fastptr.next.next;
            slowptr = slowptr.next;
        }
        fastptr = head;
        slowptr = reverseNode(slowptr);
        while (slowptr!=null){
            if(slowptr.val!=fastptr.val){
                return false;
            }
            slowptr =slowptr.next;
            fastptr = fastptr.next;
        }
        return true;
    }

    private ListNode reverseNode(ListNode middle) {
        ListNode prev = null;
        ListNode current = middle;
        while(current!=null){
            ListNode node = current.next;
            current.next =prev;
            prev = current;
            current = node;
        }
        return prev;
    }


    private void insert() {
        head = new ListNode(1,null);
        ListNode second = new ListNode(2,null);
        ListNode third = new ListNode(2,null);
        ListNode fourth = new ListNode(1,null);
        head.next = second;
        second.next =third;
        third.next = fourth;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
