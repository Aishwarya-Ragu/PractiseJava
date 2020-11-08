package stack;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {

    public static void main(String args[]){
        CloneGraph cg = new CloneGraph();
        Node clone = cg.cloneGraph();
        System.out.println(clone);
    }

    public Node cloneGraph() {
        Node root = new Node(1);
        Node sec = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);
        root.neighbors.add(sec);
        root.neighbors.add(four);
        sec.neighbors.add(root);
        sec.neighbors.add(third);
        third.neighbors.add(sec);
        third.neighbors.add(four);
        four.neighbors.add(root);
        four.neighbors.add(third);
        return root;
    }


    class Node{
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }
}
