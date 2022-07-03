import java.util.* ;
public class Stack {
    
    Queue<Integer> queue ;
    
    public Stack() {
       queue = new LinkedList<>() ;
    }

    public int getSize() { 
        return queue.size() ;
    }

    public boolean isEmpty() {
       return queue.isEmpty() ;
    }

    public void push(int element) {
       int size = queue.size() ;
       queue.offer(element) ;
       for (int i = 0 ; i < size; i++)
       {
           queue.offer(queue.poll()) ;
       }
    }

    public int pop() {
       if (isEmpty()) return -1 ;
       return queue.poll() ;
    }

    public int top() {
        if (isEmpty()) return -1 ;
        return queue.peek() ;
    }
}
