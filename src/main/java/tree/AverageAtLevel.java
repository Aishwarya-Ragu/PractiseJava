package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageAtLevel {
    Node root;
    int ans;

    List<Integer> list = new ArrayList<>();
    int min =Integer.MAX_VALUE;

    public static void main(String[] args) {
        AverageAtLevel pt = new AverageAtLevel();
        pt.insert();
        //System.out.println(pt.printUsingQueue(pt.root));
        //System.out.println(pt.diameterOfBinaryTree(pt.root));
        //System.out.println(pt.removeLeafNodes(pt.root,5));
        System.out.println(pt.minDepth(pt.root));
    }
    private Node insert() {
        root = new Node(2);
        Node second = new Node(2);
        Node third = new Node(5);
        root.left = second;
        root.right = third;
        Node four = new Node(5);
        Node five = new Node(7);
        second.left = four;
        second.right = five;
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

    public List<Double> printUsingQueue(Node root){
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<Double> average = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            int count = 0;
            while(size > 0){
                Node res = q.remove();
                sum+= res.val;
                count++;
                // Pushing left child current node
                if (res.left != null)
                    q.add(res.left);
                // Pushing right child current node
                if (res.right != null)
                    q.add(res.right);
                size--;
            }
            average.add(sum/count);


        }
        return average;
    }

    public int diameterOfBinaryTree(Node root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(Node node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }
    public int findSecondMinimumValue(Node root) {
        Node min = root;
        boolean isSecondMax = false;
        return 0;
    }

    public Node removeLeafNodes(Node root, int target) {
        removeNodes(root,target);
        return root;
    }

    private void removeNodes(Node current, int target) {
        current.left = null;
        /*if(current != null){
            if(current.left == null && current.right == null && current.val == target){
                current = null;
            }
            if(current!=null) removeNodes(current.left,target);

            if(current!=null) removeNodes(current.right,target);
        }*/
    }

    public int minDepth(Node root) {
        minDepthRecurse(root,0);
        return min;
    }

    public void minDepthRecurse(Node root, int level){
        if(root.left == null && root.right ==null){
            min = Math.min(level,min);
        }else{
             minDepthRecurse(root.left,level+1);
             minDepthRecurse(root.right,level+1);
        }
    }


}



