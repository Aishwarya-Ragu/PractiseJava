package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RangeSumBST {
    Node root;

    public static void main(String[] args) {
        RangeSumBST pt = new RangeSumBST();
        pt.insert();
        int L = 7;
        int R= 15;
        //System.out.println(pt.rangeSumBST(pt.root, L,  R));
        System.out.println(pt.isValidBST(pt.root));
    }

    public int rangeSumBST(Node root, int L, int R) {
        Stack<Node> st = new Stack<>();
        int sum = 0;
        st.push(root);
        while(!st.isEmpty()){
            Node cur = st.pop();
            if(cur.val >= L && cur.val <= R){
                sum+=cur.val;
                if(cur.left!=null) st.push(cur.left);
                if(cur.right!=null) st.push(cur.right);
            }else if (!(cur.val < R)){
                if(cur.left!=null) st.push(cur.left);
            }else if (!(cur.val > R)){
                if(cur.right!=null) st.push(cur.right);
            }
        }
        return sum;
    }

    private Node insert() {
        root = new Node(5);
        Node second = new Node(1);
        Node third = new Node(4);
        root.left = second;
        root.right = third;
        Node four = new Node(3);
        Node five = new Node(6);
        third.left = four;
        third.right = five;
        return root;
    }

    public boolean helper(Node node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.left, lower, val)) return false;
        if (! helper(node.right, val, upper)) return false;
        return true;
    }

    public boolean isValidBST(Node root) {
        return helper(root, null, null);
    }

    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;

        }
    }
}
