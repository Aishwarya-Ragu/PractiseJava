package tree;

import java.util.*;

public class VerticalOrderTraversal {
    Node head;

    public static void main(String[] args) {
        VerticalOrderTraversal vt = new VerticalOrderTraversal();
        vt.insert();
        System.out.println(vt.verticalTraversal(vt.head));
    }
    class NewRoot{
        Node root;
        int row;
        int column;
        NewRoot(Node t, int r, int col){
            this.root=t; this.row=r; this.column=col;
        }
    }
    public List<List<Integer>> verticalTraversal(Node root) {
        Map<Integer, List<NewRoot>> map=new TreeMap<>();
        Queue<NewRoot> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        queue.offer(new NewRoot(root,0,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                NewRoot tmp=queue.poll();
                Node tmpNode=tmp.root;
                int tmpRow=tmp.row;
                int tmpCol=tmp.column;
                List<NewRoot> tmpList=map.getOrDefault(tmpCol, new ArrayList<>());
                tmpList.add(tmp);
                map.put(tmpCol, tmpList);
                if(tmpNode.left!=null){
                    queue.offer(new NewRoot(tmpNode.left, tmpRow+1, tmpCol-1));
                }
                if(tmpNode.right!=null){
                    queue.offer(new NewRoot(tmpNode.right, tmpRow+1, tmpCol+1));
                }
            }
        }
        for(Map.Entry<Integer, List<NewRoot>> entry:map.entrySet()){
            List<NewRoot> list=entry.getValue();
            List<Integer> result=new ArrayList<>();
            Collections.sort(list, (a,b)->{
                if(a.row==b.row){
                    return a.root.val-b.root.val;
                } else{
                    return a.row-b.row;
                }
            });
            for(NewRoot nr:list){
                result.add(nr.root.val);
            }
            res.add(result);
        }
        return res;
    }
    private void insert() {
        head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        head.left = second;
        head.right = third;
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        second.left = four;
        second.right = five;
        third.left = six;
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

}
