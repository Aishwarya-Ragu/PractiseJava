package tree;

import java.util.*;

public class PreOrderTraversal {
    Node root;
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        PreOrderTraversal pt = new PreOrderTraversal();
        pt.insert();
        //int height = pt.height(pt.root);
        //System.out.println(height);
        //System.out.println(pt.preorderTraversal(pt.root));
        //System.out.println(pt.preOrderWithStack(pt.root));
        //System.out.println(pt.inOrderWithStack(pt.root));
        //System.out.println(pt.postOrderWithStack(pt.root));
        System.out.println(pt.LevelOrderWithQueue(pt.root));
    }

    private int height(Node root) {
        if(root == null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r)+1;
    }

    public List<Integer> preorderTraversal(Node root) {
        if(root!=null) orderTraversal(list,root);
        return list;
    }

    public void orderTraversal(List<Integer> list,Node root) {
        if(root!=null){
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public List<Integer> preOrderWithStack(Node root){
        Stack<Node> st = new Stack<Node>();
        List<Integer> list = new ArrayList<>();
        while(true){
            while(root!=null){
                st.push(root);
                list.add(root.val);
                root = root.left;
            }
        if(st.isEmpty()) return list;
            Node cur = st.pop();
            root = cur.right;
        }
    }

    public List<Integer> inOrderWithStack(Node root){
        Stack<Node> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(true){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            if(st.isEmpty()) return  list;

            Node cur = st.pop();
            list.add(cur.val);
            root =cur.right;
        }

    }

    public List<Integer> postOrderWithStack(Node root){
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Stack<Node> stack = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node cur = st.pop();
            stack.push(cur);
            if(cur.left!=null)
            st.push(cur.left);
            if(cur.right!=null)
            st.push(cur.right);
        }
        while(!stack.isEmpty()){
            list.add(stack.pop().val);
        }
        return list;
    }


    public List<List<Integer>> LevelOrderWithQueue(Node root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> listSmall = new ArrayList<>();
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur!=null){
                listSmall.add(cur.val);
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
            }
            if(cur == null){
                list.add(listSmall);
                if(!queue.isEmpty()){
                    queue.add(null);
                    listSmall = new ArrayList<>();
                }

                }
            }

        return list;
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
}


