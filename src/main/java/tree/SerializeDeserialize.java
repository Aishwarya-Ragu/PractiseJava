package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

    Node head;
    public static void main(String[] args) {
        SerializeDeserialize sd = new SerializeDeserialize();
        sd.insert();
        //System.out.println(sd.serialize(sd.head));
        sd.deserialize(sd.serialize(sd.head));

    }

    private void insert() {
        head = new Node(3);
        Node second = new Node(4);
        Node third = new Node(5);
        head.left = second;
        head.right = third;
        Node four = new Node(1);
        Node five = new Node(2);
        third.left = four;
        third.right = five;
    }

    public String serialize(Node root) {
        /*Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if (node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString().trim();*/
        StringBuilder sb = new StringBuilder();
        serializeString(root,sb);
        return sb.toString();
    }

    private void serializeString(Node root,StringBuilder sb) {
          if(root==null)
              sb.append("null ");
          else{
              sb.append(root.val+" ");
              serializeString(root.left,sb);
              serializeString(root.right,sb);
          }
    }

    public Node deserialize(String data) {
        /*String[] str = data.split(" ");
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(str[0]));
        queue.add(root);
        for(int i =1;i<str.length;i++){
            Node ele = queue.poll();
            if(!str[i].equals("n")){
                Node left = new Node(Integer.parseInt(str[i]));
                ele.left=left;
                queue.add(left);
            }
            if(++i<str.length && !str[i].equals("n")){
                Node right = new Node(Integer.parseInt(str[i]));
                ele.right=right;
                queue.add(right);
            }
        }
        return root;*/
        String str[] = data.split(" ");
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(str));
        Node t = deserializeStr(q);
        System.out.println(t);
        return t;
    }

    private Node deserializeStr(Queue<String> queue) {
        String ele = queue.poll();

        if(!ele.equals("null")){
            Node parent = new Node(Integer.parseInt(ele));
            parent.left = deserializeStr(queue);
            parent.right = deserializeStr(queue);
            return parent;
        }
        return null;
    }

    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
}



