package LeetCode;

import tree.LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class HouseRobber3 {
    Node root;

    private Node insert() {
        root = new Node(3);
        Node second = new Node(4);
        Node third = new Node(5);
        root.left = second;
        root.right = third;
        Node four = new Node(1);
        Node five = new Node(3);
        second.left = four;
        second.right = five;
        Node six = new Node(1);
        third.right = six;
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
    public static void main(String[] args) {
        HouseRobber3 pt = new HouseRobber3();
        pt.insert();
        pt.rob(pt.root);
    }

    public int rob(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int oddLevelSum = 0;
        int evenLevelSum = 0;
        boolean isOddLevel = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean oddSet = false;
            while(size > 0){
                Node current = queue.remove();
                if(current.left !=null) queue.add(current.left);
                if(current.right !=null) queue.add(current.right);

                if(isOddLevel){
                    oddLevelSum = oddLevelSum + current.val;
                    oddSet = true;
                }else{
                    evenLevelSum = evenLevelSum +current.val;
                }
                size--;
            }
            isOddLevel = !oddSet;
        }
        return Math.max(oddLevelSum,evenLevelSum);
    }
}
