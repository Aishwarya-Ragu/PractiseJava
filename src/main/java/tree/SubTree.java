package tree;

public class SubTree {
    Node s;
    Node t;

    public static void main(String[] args) {
        SubTree st = new SubTree();
        st.insertS();
        st.insertT();
        System.out.println(st.isSubtree(st.s,st.t));
    }

    public boolean isSubtree(Node s, Node t) {
        Node subTreeS = searchSubTree(s,t);
        if(subTreeS != null){
            return identicalTree(subTreeS,t);
        }
        return false;
    }

    private boolean identicalTree(Node root, Node root1) {
        if(root != null && root1 != null){
            return true;
        }
        if(root != null || root1 != null){
            return true;
        }
        return root.val == root1.val && identicalTree(root.left,root1.left) && identicalTree(root.right,root1.right);
    }

    private Node searchSubTree(Node s, Node t) {
        if(s == null){
            return null;
        }
        if(s.val == t.val){
            return s;
        }
        Node sub = searchSubTree(s.left,t);
        if(sub!= null){
            return sub;
        }
        return searchSubTree(s.right,t);
    }

    private void insertS() {
        s = new Node(3);
        Node second = new Node(4);
        Node third = new Node(5);
        s.left = second;
        s.right = third;
        Node four = new Node(1);
        Node five = new Node(2);
        second.left = four;
        second.right = five;
    }

    private void insertT() {
        t = new Node(4);
        Node second = new Node(1);
        Node third = new Node(2);
        t.left = second;
        t.right = third;
    }

    class Node {
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
