package LinkedList;

import java.util.List;

public class AddTwoNumber2 {
    ListNode firstHead = null;
    ListNode secondHead = null;
    public static void main(String[] args) {
        AddTwoNumber2 in = new AddTwoNumber2();
        in.insert();
        System.out.println(in.addTwoNumbers(in.firstHead,in.secondHead));
    }

    class Result{
        ListNode full_list =null;
        int carry =0;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        int diff = Math.abs(len2-len1);
        if(len1<len2){
            l1 = padBefore(l1,diff);
        }else if(len2 <len1){
            l2 = padBefore(l2,diff);
        }
        Result res = addNumbers(l1,l2);
        ListNode ele = res.carry > 0 ? padElement(res.full_list,res.carry):res.full_list;
        return ele;
    }

    private Result addNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 ==null){
            Result res = new Result();
            return  res;
        }
        Result sum = addNumbers(l1.next,l2.next);
        int value = l1.val+l2.val+sum.carry;
        sum.full_list = padElement(sum.full_list,value%10);
        sum.carry = value/10;
        return sum;
    }

    private ListNode padBefore(ListNode node,int diff){
        for(int i =0;i<diff;i++){
            node = padElement(node,0);
        }
        return node;
    }

    private ListNode padElement(ListNode node,int ele){
        ListNode nodeEle = new ListNode(ele);
        if(node!=null){
            nodeEle.next = node;
        }
        return nodeEle;
    }



    public int length(ListNode list){
        int count =0;
        while(list != null){
            count++;
            list = list.next;
        }
        return count;
    }


    private void insert() {
        firstHead = new ListNode(7,null);
        ListNode second = new ListNode(2,null);
        ListNode third = new ListNode(4,null);
        ListNode fourth = new ListNode(3,null);

        firstHead.next = second;
        second.next =third;
        third.next = fourth;

        secondHead = new ListNode(5,null);
        ListNode four = new ListNode(6,null);
        ListNode five = new ListNode(4,null);
        secondHead.next = four;
        four.next = five;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
