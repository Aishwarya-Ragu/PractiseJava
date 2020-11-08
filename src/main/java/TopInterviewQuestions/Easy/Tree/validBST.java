package TopInterviewQuestions.Easy.Tree;

public class validBST {
    TreeNode head;
    public static void main(String[] args) {
        validBST vb = new validBST();
        vb.insert();
        vb.isValidBST(vb.head);
    }

    public boolean isValidBST(TreeNode root) {
        return validBSTUtil(root,null,null);
    }

    public boolean validBSTUtil(TreeNode root,TreeNode min,TreeNode max){
        if(root == null)
            return true;
        if(min == null && max!=null && root.val >= max.val)
            return false;
        if(max == null && min!=null && root.val <= min.val)
            return false;
        return validBSTUtil(root.left,min,root) &&
                validBSTUtil(root.right,root,max);

    }

    public void insert(){
        head = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        head.left = left;
        head.right = right;

        TreeNode thirdLeft = new TreeNode(6);
        TreeNode thirdRight = new TreeNode(20);
        right.left = thirdLeft;
        right.right = thirdRight;
    }
}






class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val =val;
    }
}