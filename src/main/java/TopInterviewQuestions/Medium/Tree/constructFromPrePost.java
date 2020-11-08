package TopInterviewQuestions.Medium.Tree;

public class constructFromPrePost {
    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        constructFromPrePost cty = new constructFromPrePost();
        System.out.println(cty.constructFromPrePost(pre,post));
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int preend = pre.length-1;
        int postend = post.length-1;
        return recurse(pre,0,preend,post,0,postend);
    }

    public TreeNode recurse(int[] pre,int prestart, int preend, int [] post,int poststart,int postend){
        if(prestart > preend || poststart > postend || prestart+1 > pre.length)
            return null;

        int val = pre[prestart];
        TreeNode root = new TreeNode(val);

        int search = pre[prestart+1];
        int index =0;

        for(int j =0;j<post.length;j++){
            if(post[j] == search){
                index = j;
                break;
            }
        }

        root.left = recurse(pre,prestart+1,prestart+1+index,post,poststart,index);
        root.right = recurse(pre,prestart+2+index,preend,post,index+1,postend);
        return root;

    }

    public class TreeNode {
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

}


