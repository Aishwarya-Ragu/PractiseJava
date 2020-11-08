package LinkedList;

import java.util.Stack;

public class NextGreaterElementLinkdList {
    ListNode head = null;
    public static void main(String[] args) {
        NextGreaterElementLinkdList in = new NextGreaterElementLinkdList();
        in.insert();
        System.out.println(in.nextLargerNodes(in.head));
    }

    class Wrapper{
        int index;
        int num;
        Wrapper(int index,int num){
            this.index = index;
            this.num = num;
        }
    }




    public int[] nextLargerNodes(ListNode head) {
        ListNode current = head;
        int len = lengthList(head);
        Stack<Wrapper> st = new Stack<>();
        int a[] = new int[len];
        int i =0;
        while(current!=null){
                while(!st.isEmpty()  && st.peek().num < current.val){
                    a[st.pop().index] = current.val;
                }
            st.push(new Wrapper(i,current.val));
            i++;
            current = current.next;
        }
        if(current == null){
            while(!st.isEmpty()){
                a[st.pop().index] =0;
            }
        }
        return a;
    }

    private int lengthList(ListNode head) {
        int count =0;
        while(head!=null){
            count++;
            head= head.next;
        }
        return count;
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
