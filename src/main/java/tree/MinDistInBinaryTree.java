/*
package tree;

import java.util.ArrayList;
import java.util.List;

public class MinDistInBinaryTree {
    Node root;
    List<List<Integer>>listOfNum = new ArrayList<>();

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
        MinDistInBinaryTree mt = new MinDistInBinaryTree();
        mt.insert();
        //System.out.println(mt.getMinimumDifference(mt.root));
        System.out.println(mt.pathSum(mt.root,22));
    }

    private Node insert() {
        root = new Node(5);
        Node second = new Node(4);
        Node third = new Node(8);
        root.left = second;
        root.right = third;
        Node four = new Node(11);
        Node five = new Node(7);
        Node six = new Node(2);
        second.left = four;
        four.left = five;
        four.right = six;
        Node seve = new Node(13);
        Node eig = new Node(4);
        Node nin = new Node(5);
        Node te = new Node(1);
        third.left = seve;
        third.right = eig;
        eig.left = nin;
        eig.right = te;
        return root;
    }

    */
/*public int getMinimumDifference(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root,list);
        int size = list.size();
        int i =0,j=1;
        int min = Integer.MAX_VALUE;
        while(i<size && j<size){
            min = Math.min(min,Math.abs(list.get(i)-list.get(j)));
            i++;
            j++;
        }
        return min;
    }*//*



    public List<List<Integer>> pathSum(Node root, int sum) {
        int rsum = 0;
        pathTraverse(root,sum,rsum,new ArrayList<>());
        return listOfNum;
    }

    public void pathTraverse(Node root, int sum, int rsum,List<Integer> list)
    {
        if(root!=null){
            rsum+=root.val;
            list.add(root.val);
            if(rsum == sum && root.left == null && root.right == null){
                listOfNum.add(list);
            }
            pathTraverse(root.left,sum,rsum,new ArrayList<>(list));
            pathTraverse(root.right,sum,rsum,new ArrayList<>(list));
            int sums = 265;
            Integer.pa


        }

        Integer.
  }


}
*/
