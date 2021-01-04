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
        //pt.zigzagLevelOrder(pt.root);
        //pt.findTilt(pt.root);
        pt.maxAncestorDiff(pt.root);
    }
    private Node insert() {
        root = new Node(8);
        Node second = new Node(3);
        Node third = new Node(10);
        root.left = second;
        root.right = third;
        Node four = new Node(1);
        Node five = new Node(6);
        second.left = four;
        second.right = five;
        Node six = new Node(14);
        third.right = six;
        Node seven = new Node(4);
        Node eight = new Node(7);
        Node nine = new Node(13);
        five.left =seven;
        five.right = eight;
        six.right = nine;
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

    class Answer{
        int total;
        Answer(){ }
    }

    public int findTilt(Node root) {
        int total = 0;
        Answer answer = new Answer();
        tiltRecursive(root,answer);
        return answer.total;
    }

    public int tiltRecursive(Node root,Answer answer){
        if(root == null)
            return 0;
        int left = tiltRecursive(root.left,answer);
        int right = tiltRecursive(root.right,answer);
        answer.total = answer.total + Math.abs(left-right);
        return root.val+left+right;
    }

    int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(Node root) {
        Set<Node> set = new HashSet<>();
        set.add(root);
        maxAncestorDiffRecurse(root,set);
        return maxDiff;
    }

    public void maxAncestorDiffRecurse(Node root,Set<Node> set){
        if(root!=null){
            for(Node node:set){
                int max = Math.abs(root.val-node.val);
                maxDiff = Math.max(max,maxDiff);
            }
            set.add(root);
            maxAncestorDiffRecurse(root.left,set);
            set.remove(set.size()-1);
            maxAncestorDiffRecurse(root.right,set);
            set.remove(set.size()-1);
        }
    }

}
