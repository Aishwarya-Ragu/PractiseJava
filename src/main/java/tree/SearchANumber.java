package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchANumber {
    Node root;
    List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        SearchANumber pt = new SearchANumber();
        pt.insert();
        //System.out.println(pt.searchBST(pt.root,2));
        //System.out.println(pt.leafSimilar(pt.root,null));
        //System.out.println();
        System.out.println(pt.isSameTree(pt.root,null));

    }

    public Node searchBST(Node root, int val) {
        if(root.val == val){
            return root;
        }
        return root.val < val ?searchBST(root.left,val):  searchBST(root.right,val);
    }

    public boolean leafSimilar(Node root1, Node root2) {
        List<Integer> lt = similar(root1,new LinkedList<>());
        int arr[] ={4,6,5};
        LinkedList<Integer> a = Arrays.stream(arr).mapToObj(ab -> (Integer) ab).collect(Collectors.toCollection(LinkedList::new));
        return lt.equals(a);
    }

    public List<Integer> similar(Node root, List<Integer> list){
        if(root.left == null && root.right == null){
            list = list == null? new LinkedList<>():list;
            list.add(root.val);
            return list;
        }
        if(root.left!=null)
            list =  similar(root.left,list);
        if(root.right!=null)
            list= similar(root.right,list);
        return list;
    }

    public List<Integer> isSameTree(Node p, Node q) {
        List<Integer> list = new ArrayList<>();
        isSame(p,list);
        return list;
    }

    public void isSame(Node root,List<Integer> list){
        if(root!=null){
            list.add(root.val);
            isSame(root.left,list);
            isSame(root.right,list);
        }else{
            list.add(null);
        }
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
