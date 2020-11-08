package May;

public class BinaryTreeCousin {
    static class NodeInfo{
        int val;
        int level;
        TreeNode parent;
        NodeInfo(int val,int level,TreeNode parent){
            this.val = val;
            this.level = level;
            this.parent = parent;
        }
    }
    public static void main(String args[]){
        TreeNode left = new TreeNode(2,new TreeNode(4),new TreeNode());
        TreeNode right = new TreeNode(3,new TreeNode(5),new TreeNode());
        TreeNode root = new TreeNode(1,left,right);
        int x=2;
        int y =4;
        System.out.println(isCousin(root,x,y));
    }

    private static boolean isCousin(TreeNode root,int x, int y) {
        BinaryTreeCousin bt = new BinaryTreeCousin();
        int level = -1;
        NodeInfo firstNode = new NodeInfo(x,-1,null);
        NodeInfo secondNode = new NodeInfo(y,-1,null);

        bt.recursiveIsCousin(root,null,level,firstNode,secondNode);
        if(firstNode.level == secondNode.level && firstNode.parent.val != secondNode.parent.val)
            return true;
        else return false;

    }
    void recursiveIsCousin(TreeNode root,TreeNode parent,int level,NodeInfo x,NodeInfo y){
        if(root == null){
            return;
        }else{
            recursiveIsCousin(root.left,root,level+1,x,y);
            if(root.val == x.val){
                x.parent = parent;
                x.level = level;
            }
            if(root.val == y.val){
                y.parent = parent;
                y.level = level;
            }
            recursiveIsCousin(root.right,root,level+1,x,y);
        }

    }
}


 // Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
 }


