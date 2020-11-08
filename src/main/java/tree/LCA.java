package tree;

public class LCA {
    Node root;

    public static void main(String[] args) {
        LCA lc = new LCA();
        lc.insert();
        System.out.println(lc.countNodes(lc.root));
    }

    public int countNodes(Node root) {
        if(root == null){
            return 0;
        }
        int lcount = countNodes(root.left);
        int rcount = countNodes(root.right);
        return (lcount+rcount+1);
    }

    private Node insert() {
        root = new Node(6);
        Node second = new Node(2);
        Node third = new Node(8);
        root.left = second;
        root.right = third;
        Node four = new Node(0);
        Node five = new Node(4);
        second.left = four;
        second.right = five;
        Node six = new Node(7);
        Node seven = new Node(9);
        third.left = six;
        third.right = seven;
        return root;
    }


    /*public Node lowestCommonAncestor(Node root) {
        lca(root,new Node(2),new Node(8));

    }

    private Node lca(Node root, Node node, Node node1) {
    }*/

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
