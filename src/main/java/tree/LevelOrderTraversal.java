package tree;

import java.util.*;

public class LevelOrderTraversal {
    Node root;
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        LevelOrderTraversal pt = new LevelOrderTraversal();
        pt.insert();
        //pt.printUsingQueue();
        //pt.printLevelOrder();
        pt.zigzagLevelOrder(pt.root);
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

    public void printUsingQueue(){
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();

        // Pushing root node into the queue.
        q.add(root);

        // Pushing delimiter into the queue.
        q.add(null);

        // Executing loop till queue becomes
        // empty
        while (!q.isEmpty()) {

            Node curr = q.poll();

            // condition to check the
            // occurence of next level
            if (curr == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    System.out.println();
                }
            } else {
                // Pushing left child current node
                if (curr.left != null)
                    q.add(curr.left);

                // Pushing right child current node
                if (curr.right != null)
                    q.add(curr.right);

                System.out.print(curr.val + " ");
            }
        }

    }

    private int height(Node root) {
        if(root == null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r)+1;
    }


    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
        {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    void printGivenLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.println(root.val);
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> result =  null;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.add(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            result = new ArrayList<>();
            while(!s1.isEmpty()){
                Node ele = s1.pop();
                result.add(ele.val);
                if(ele.left != null) s2.add(ele.left);
                if(ele.right != null) s2.add(ele.right);
            }
            list.add(result);
            result = new ArrayList<>();
            while(!s2.isEmpty()){
                Node ele = s2.pop();
                result.add(ele.val);
                if(ele.right != null) s1.add(ele.right);
                if(ele.left != null) s1.add(ele.left);
            }
           // if(CollectionUtils.islist.add(result);
        }
        return list;


    }
}
