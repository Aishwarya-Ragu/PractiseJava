package LinkedList;

public class Insertion {
    Node head;
    public static void main(String[] args) {
        Insertion in = new Insertion();
        in.insertion();
        in.printList();
         in.insertAtTop( 6);
        in.printList();
        in.insertAtEnd(10);
        in.printList();
        in.insertAfterSix(12,10);
        in.printList();
        in.deleteNode(1);
        in.printList();
        in.deleteNodeAtIndex(0);
        in.printList();
    }

    private void deleteNodeAtIndex(int index) {
        Node current = head;
        Node prevNode = head;
        int i =0;
        if(index == 0){
            head = current.next;
            return;
        }
        while(i != index && current!=null){
            prevNode = current;
            current = current.next;
            i++;
        }
        Node temp = current;
        prevNode.next = temp.next;
        return;


    }

    private void deleteNode(int i) {
        Node current = head;
        Node prevNode = head;
        while(current.data != i && current!=null){
            prevNode = current;
            current = current.next;
        }
        Node temp = current;
        prevNode.next = temp.next;
        return;

    }

    private void insertAfterSix(int ele, int afterElement) {
        Node current = head;
        while(current.data != afterElement){
            current = current.next;
        }
        Node newNode = new Node(ele);
        newNode.next = current.next;
        current.next = newNode;

    }

    private void insertAtEnd(int data) {
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = new Node(data);
    }

    private Node insertAtTop(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
        Node(){
            next = null;
        }
    }

    Node insertion(){
        head= new Node(2);
        Node second = new Node(1);
        Node third = new Node(3);
        head.next =second;
        second.next = third;
        return head;
    }

    void printList(){
        Node current = head;
        while(current!=null){
            System.out.println(current.data);
            current = current.next;
        }
    }


}
