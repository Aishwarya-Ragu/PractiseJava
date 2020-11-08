/*
public class circularQueue {

    int front = -1;
    int rear = -1;
    int[] queue = null;
    public circularQueue(int k) {
        queue = new int[k];
    }

    */
/** Insert an element into the circular queue. Return true if the operation is successful. *//*

    public boolean enQueue(int value) {
        int len = queue.length;


            rear++;
            queue[rear] = value;
            if(front == -1)
                front = rear;
            return true;

        return false;

    }

    */
/** Delete an element from the circular queue. Return true if the operation is successful. *//*

    public boolean deQueue() {
        if(front!=-1){
            queue[front] = null;
            front++;
        }

    }

    */
/** Get the front item from the queue. *//*

    public int Front() {
        if(front != -1)
            return queue[front];
        return 0;
    }

    */
/** Get the last item from the queue. *//*

    public int Rear() {
        if(rear!=-1)
            return queue[rear];
        return 0;
    }

    */
/** Checks whether the circular queue is empty or not. *//*

    public boolean isEmpty() {
        if(front ==-1 && rear == -1)
            return true;
        return false;
    }

    */
/** Checks whether the circular queue is full or not. *//*

    public boolean isFull() {
        if(front == rear)
            return true;
        return false;

    }

    public static void main(String[] args) {
        circularQueue cq = new circularQueue(7);

    }
}
*/
