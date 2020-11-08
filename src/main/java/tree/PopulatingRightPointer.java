package tree;

public class PopulatingRightPointer {
    Node head;
    public static void main(String[] args) {
        PopulatingRightPointer pr = new PopulatingRightPointer();
        pr.insert();
        System.out.println(pr.connect(pr.head));

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
        third.right = six;
    }

    public Node connect(Node root) {
        if(root == null)
            return null;
        if(root.left!=null && root.right!=null){
            root.left.next = root.right;
            root.right.next = getNext(root.next);
        }else if(root.left!=null)
            root.left.next = getNext(root.next);
        else if(root.right != null)
            root.right.next = getNext(root.next);
        connect(root.right);
        connect(root.left);
        return root;

    }

    public Node getNext(Node root){
        root.right.next = (root.next!=null) ? (root.next.left!=null) ? root.next.left:null:null;

        if(root == null)
            return null;
        else if(root.left!=null)
            return root.left;
        else if(root.right != null)
            return root.right;
        return root;
    }

}

class Node{
    int val;
    Node left;
    Node right;
    Node next;
    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
