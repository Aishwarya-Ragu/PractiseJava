package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalII {
    Node root;
    int sum =0;
    //List<Integer> list = new ArrayList<>();
    List<List<Integer>> mainList = new ArrayList<>();

    public static void main(String[] args) {
        LevelOrderTraversalII pt = new LevelOrderTraversalII();
        pt.insert();
        //System.out.println(pt.levelOrderBottom(pt.root));
        System.out.println(pt.sumOfLeftLeaves(pt.root));
    }
    private Node insert() {
        root = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        root.left = second;
        root.right = third;
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        second.left = four;
        second.right = five;
        third.left = six;
        return root;
    }

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

    public int sumOfLeftLeaves(Node root) {
        return sumUtils(root);
    }

    public int sumUtils(Node root){
        if(root == null)
            return 0;
        else if(root.left != null){
            sum+=root.left.val;
        }
        sumUtils(root.left);
        sumUtils(root.right);
        return sum;
    }

    /*public List<List<Integer>> levelOrderBottom(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.println(queue.size());
        while (!queue.isEmpty()){
            list = new ArrayList<>();
            int size = queue.size();
            while(size!=0){
                Node cur = queue.poll();
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
                list.add(cur.val);
                size--;
            }
            bottomList.addFirst(list);
        }
        return bottomList;
    }*/

/*    public List<List<Integer>> levelOrderBottom(Node root) {
        int level = heightOfTree(root);
        addAtLevel(root,level);
        return mainList;
    }


    public void addAtLevel(Node root, int level){
        for(int i = level; i >= 1;i--){
            List<Integer> list = new ArrayList<>();
            addListAtLevel(root,i,list);
            mainList.add(list);
        }
    }


    public void addListAtLevel(Node root, int level, List<Integer> list){
        if(root!=null){
            if(level == 1){
                list.add(root.val);
            }else{
                addListAtLevel(root.left,level-1,list);
                addListAtLevel(root.right,level-1,list);
            }
        }
    }


    public int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return Math.max(left,right)+1;
    }*/

    public List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null) {
            return resList;
        }
        dfs(root, 0, resList);
        return resList;
    }

    public void dfs(Node root, int depth, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        if(depth == res.size()) {
            res.add(0, new ArrayList<Integer>());
        }
        res.get(res.size() - depth - 1).add(root.val);
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }



}
