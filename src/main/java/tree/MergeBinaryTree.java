package tree;

public class MergeBinaryTree {
    Node root1;
    Node root2;
    public static void main(String args[]){
        MergeBinaryTree mb = new MergeBinaryTree();
        mb.insert();
        mb.mergeTrees(mb.root1,mb.root2);
    }

    public void mergeTrees(Node root1, Node root2) {
        if(root1!=null && root2!=null){
            root1.val = root1.val+root2.val;
            mergeTrees(root1.left,root2.left);
            mergeTrees(root1.right,root2.right);
        }else if(root1 == null && root2 != null){
            root1 = new Node(root2.val);
            mergeTrees(null,root2.left);
            mergeTrees(null,root2.right);
        }else if(root1 != null && root2 == null){
            root1 = root1;
            mergeTrees(root1.left,null);
            mergeTrees(root1.right,null);
        }

    }

    private void insert() {
        root1 = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        root1.left = second;
        root1.right = third;
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        second.left = four;
        second.right = five;
        third.left = six;

        root2 = new Node(1);
        Node headOne = new Node(2);
        Node headTwo = new Node(3);
        root2.left = headOne;
        root2.right = headTwo;
    }


    class Node {
        int val;
        Node left,right;
        Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
        Node(){
            this.val =0;
            left =null;
            right = null;
        }
    }
}
