package tree;

public class DeleteNodeInBST {
    Tree head;
    public static void main(String[] args) {
        DeleteNodeInBST db = new DeleteNodeInBST();
        db.insert();
        int key =7;
        db.deleteNode(key);


    }

    private Tree deleteNode(int key) {
        Tree search = searchNode(head,key);
        System.out.println(search);
        return  search;
    }

    private Tree searchNode(Tree node, int key) {
        if(node!=null){
            if(node.val == key)
                node= delete(node);
            else if(key < node.left.val)
                node.left =  searchNode(node.left,key);
            else
                node.right = searchNode(node.right,key);
        }
        return node;
    }

    private Tree delete(Tree node) {
        if(node.left == null && node.right == null)
            return null;
        else if(node.left==null)
            return node.right;
        else if(node.right==null)
            return node.left;
        Tree helper = node.right;
        while(helper!=null){
            helper = helper.left;
        }
        helper.left = node.left;
        return node.right;
    }

    public void insert(){
        head = new Tree(5);
        Tree first = new Tree(3);
        Tree second = new Tree(6);
        head.left = first;
        head.right = second;
        Tree third = new Tree(2);
        Tree fourth = new Tree(4);
        first.left = third;
        first.right = fourth;
        Tree five = new Tree(7);
        second.right = five;
    }


}

class Tree{
    int val;
    Tree left;
    Tree right;
    Tree(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
