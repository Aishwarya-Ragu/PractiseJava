package GeekForGeekMustDo.Tree;

import java.util.*;

public class BottomLevelView {
    public static void main(String[] args) {
        TreeConstruction tc = new TreeConstruction();
        TreeNode head = tc.head;
        BottomLevelView blv = new BottomLevelView();
        List<Integer> list = blv.bottomView(head);
        System.out.println(list);
    }

    public List<Integer> bottomView(TreeNode root) {
        Map<Integer,TempNode> map = new TreeMap<>();
        Queue<TempNode> q = new LinkedList<>();
        TempNode temp = new TempNode(root,0);
        q.add(temp);
        map.put(0,temp);
        while(!q.isEmpty()){
            TempNode tempN = q.poll();
            if(tempN.node.left !=null){
                int lcol = tempN.col -1;
                TempNode left = new TempNode(tempN.node.left,lcol);
                map.put(lcol,left);
                q.add(left);
            }
            if(tempN.node.right!=null){
                int rcol = tempN.col +1;
                TempNode right = new TempNode(tempN.node.right,rcol);
                map.put(rcol,right);
                q.add(right);
            }


        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,TempNode> mapE : map.entrySet()){
            res.add(mapE.getValue().node.val);
        }
        return res;

    }
}

class TempNode{
    TreeNode node;
    int col;
    TempNode(TreeNode node,int col){
        this.node = node;
        this.col = col;
    }
}
