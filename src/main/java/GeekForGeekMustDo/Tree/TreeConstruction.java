package GeekForGeekMustDo.Tree;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class TreeConstruction {
    TreeNode head;

    TreeConstruction(){
        insert();
    }

    private TreeNode insert() {
        head = new TreeNode(20);
        TreeNode second = new TreeNode(8);
        TreeNode third = new TreeNode(22);
        head.left = second;
        head.right = third;
        TreeNode four = new TreeNode(5);
        TreeNode five = new TreeNode(3);
        second.left = four;
        second.right = five;
        TreeNode six = new TreeNode(4);
        TreeNode seven = new TreeNode(25);
        third.left = six;
        third.right = seven;
        TreeNode eight = new TreeNode(10);
        TreeNode nine = new TreeNode(14);
        five.left = eight;
        five.right = nine;
        return head;
    }
}
