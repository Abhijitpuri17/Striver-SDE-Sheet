public class Queue {
    
    int[] queue ;
    int front, rear ;

    Queue() {
        queue = new int[5000] ;
        front = 0;
        rear = -1 ;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        return rear < front ;
    }

    void enqueue(int data) {
        queue[++rear] = data ;
    }

    int dequeue() {
        if (front > rear) return -1;
        return queue[front++] ;
    }

    int front() {
        if (front > rear) return -1;
        return queue[front] ;
    }

}
