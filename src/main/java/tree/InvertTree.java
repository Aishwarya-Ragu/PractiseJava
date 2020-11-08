package tree;

public class InvertTree {
    Node head;
    public static void main(String[] args) {
        InvertTree it = new InvertTree();
        it.insert();
        System.out.println(it.invertTree(it.head));
    }

    private void insert() {
        head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        head.left = second;
        head.right = third;
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        second.left = four;
        second.right = five;
        third.left = six;
    }

    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    public Node invertTree(Node root) {
        invert(root);
        return root;
    }

    public void invert(Node root){
        if(root != null){
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left!=null) invert(root.left);
            if(root.right!=null) invert(root.right);
        }
    }
}
