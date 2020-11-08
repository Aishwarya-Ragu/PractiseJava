package tree;

public class LongestUniValuePath {
    Node head;
    public static void main(String[] args) {
        LongestUniValuePath it = new LongestUniValuePath();
        it.insert();
        System.out.println(it.longestUnivaluePath(it.head));

    }

    private void insert() {
        head = new Node(1);
        Node second = new Node(4);
        Node third = new Node(5);
        head.left = second;
        head.right = third;
        Node four = new Node(4);
        Node five = new Node(4);
        Node six = new Node(5);
        second.left = four;
        second.right = five;
        third.right = six;
    }


    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left =null;
            this.right = null;
        }
    }

    public int longestUnivaluePath(Node root) {
        int uniNode = root.val;
        int count = 0;
        int max = 0;
        max = univaluePath(root,max,count,uniNode);
        return max;
    }

    private int univaluePath(Node root, int max, int count, int uniNode) {
        count = (root.val == uniNode) ? count+1 : 0;
        uniNode = (root.val == uniNode) ? uniNode : root.val;
        max = Math.max(max,count);
        int lmax =0 ,rmax =0;
        if(root.left!=null)
            lmax = univaluePath(root.left,max,count,uniNode);
        if(root.right!=null)
            rmax = univaluePath(root.right,max,lmax,uniNode);
        return Math.max(max,Math.max(lmax,rmax));
    }
}
