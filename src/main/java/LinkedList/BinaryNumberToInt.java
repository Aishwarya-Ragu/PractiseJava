package LinkedList;

public class BinaryNumberToInt {
    ListNode head;
    public static void main(String[] args) {
        BinaryNumberToInt in = new BinaryNumberToInt();
        in.insert();
        System.out.println(in.getDecimalValue(in.head));
    }

    private void insert() {
        head = new ListNode(1,null);
        /*ListNode second = new ListNode(0,null);
        ListNode third = new ListNode(1,null);
        head.next = second;
        second.next =third;*/
    }

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while(head!=null){
            sb.append(head.val);
            head = head.next;
        }
        String str = sb.toString();
        int i = str.length();
        i--;
        int j =0;
        double a = 0;
        while( i >= 0 ){
             a = a+Integer.parseInt(String.valueOf(str.charAt(i))) * Math.pow(2,j);
            j++;
            i--;
        }
        return (int) a;
    }


    public class ListNode {
         int val;
         ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
