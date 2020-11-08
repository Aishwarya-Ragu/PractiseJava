package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum {
    Node root;
    public static void main(String[] args) {
        PathSum ps = new PathSum();
        ps.insert();
        //System.out.println(ps.hasPathSum(ps.root,22));
        System.out.println(ps.sumOfLeftLeaves(ps.root));


    }
    private Node insert() {
        root = new Node(1);
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

    public boolean hasPathSum(Node root, int sum) {
        Stack<Node> st = new Stack<Node>();
        int res = 0;
        Node current = root;
        while(!st.isEmpty() || current!=null){
            if(current!=null) {
                st.push(current);
                res += current.val;
                current = current.left;
                if(res == sum){
                    return true;
                }
                if(res > sum){
                    Node pop = st.pop();
                    res-= pop.val;
                    res = Math.abs(res);
                    if(!st.isEmpty()){
                        Node peekUp = st.peek();
                        if(peekUp.right != null)  res+=peekUp.right.val;
                        else{
                            st.pop();

                        }
                        if (res == sum) {
                            return true;
                        }else{
                            res-=peekUp.right.val;
                            st.pop();
                        }
                    }
                }
            }



        }
        return false;

    }

    public int sumOfLeftLeaves(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Node> list = new ArrayList<>();
        int sum = 0;
        if(root == null){
            return sum;
        }
        Node cur = root;
        stack.add(cur);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            if(list.contains(pop)){
                if(pop.left!=null && pop.right!=null){
                    list.remove(pop);
                }
            }
            if(pop.left!=null){
                stack.push(pop.left);
                list.add(pop.left);
            }
            if(pop.right!=null){
                stack.push(pop.right);
            }
        }
        for(Node node : list){
            sum+=node.val;
        }
        return sum;
    }

}
