package tree;

import java.util.*;

public class MaximumWidth {
    Node head;
    public static void main(String[] args) {
        MaximumWidth mw = new MaximumWidth();
        mw.insert();
        //mw.widthOfBinaryTree(mw.head);
        //mw.findMode(mw.head);
        mw.zigzagLevelOrder(mw.head);
    }

    public int widthOfBinaryTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Map<Node,Integer> map = new HashMap<>();
        queue.add(root);
        map.put(root,1);
        int width = Integer.MIN_VALUE;
        int curWidth =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int start = 0;
            int end = 0;
            for(int i =0;i<size;i++){
                Node ele = queue.poll();
                if(i == 0) start = map.get(ele);
                if(i == size-1) end = map.get(ele);

                if(ele.left!=null){
                    queue.add(ele.left);
                    map.put(ele.left,2* map.get(ele));
                }
                if(ele.right!=null){
                    queue.add(ele.right);
                    map.put(ele.right,2* map.get(ele)+1);
                }

            }
            curWidth = end-start+1;
            width = Math.max(width,curWidth);
        }
        return width;
    }

    private void insert() {
        head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        head.left = second;
        head.right = third;
        Node four = new Node(2);
        Node five = new Node(2);
        Node six = new Node(3);
        second.left = four;
        second.right = five;
        third.right = six;
    }

    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    public int[] findMode(Node root) {
        Map<Integer,Integer> countMap = new HashMap<>();
        traverseTree(root,countMap);
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> map : countMap.entrySet()){
            if(map.getValue() > 2)
                list.add(map.getKey());
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    public void traverseTree(Node root, Map<Integer,Integer> countMap){
        if(root!=null){
            countMap.put(root.val,countMap.getOrDefault(root.val,0)+1);
            traverseTree(root.left,countMap);
            traverseTree(root.right,countMap);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(Node root) {
        // TreeNode c=root;
        List<List<Integer>> ans =new ArrayList<List<Integer>>();
        //if(c==null) return ans;
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()||!s2.isEmpty())
        {
            List<Integer> tmp=new ArrayList<Integer>();
            while(!s1.isEmpty())
            {
                Node c=s1.pop();
                if(c!=null)tmp.add(c.val);
                if(c.left!=null) s2.push(c.left);
                if(c.right!=null) s2.push(c.right);
            }
            ans.add(tmp);
            tmp=new ArrayList<Integer>();
            while(!s2.isEmpty())
            {
                Node c=s2.pop();
                tmp.add(c.val);
                if(c.right!=null)s1.push(c.right);
                if(c.left!=null)s1.push(c.left);
            }
            if(!tmp.isEmpty()) ans.add(tmp);
        }
        return ans;
    }

}
