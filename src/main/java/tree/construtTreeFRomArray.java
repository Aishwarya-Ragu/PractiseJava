package tree;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


public class construtTreeFRomArray {

    public static void main(String args[]) {
        construtTreeFRomArray ar = new construtTreeFRomArray();
        int arr[] = {1, 2, 3, 4, 5, 6};
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode n =new TreeNode(arr[0]);
        q.add(n);
        for(int i =1 ; i<arr.length ; i++){
            TreeNode node = q.poll();
            TreeNode ele = new TreeNode(arr[i]);
            node.left = ele;
            q.add(ele);
            if(++i<arr.length){
                TreeNode ele1 = new TreeNode(arr[i]);
                node.right = ele1;
                q.add(ele1);
            }
        }
        System.out.println(n);
    }

    /*private TreeNode buildTree(Queue<Integer> q) {
        if(q.isEmpty())
            return null;
        int ele = q.poll();
        TreeNode node = new TreeNode(ele);
        node.left = buildTree(q);
        node.right = buildTree(q);
        return node;


    }*/
}

