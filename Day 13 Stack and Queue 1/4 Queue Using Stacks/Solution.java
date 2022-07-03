import java.util.* ;
public class Queue {
   
    Stack<Integer> stack1, stack2 ;
    
    Queue() {
        stack1 = new Stack<>() ;
        stack2 = new Stack<>() ;
    }

    void enQueue(int val) {
        stack1.push(val) ;
    }

    int deQueue() {
        if (stack1.isEmpty()) return -1 ;
        while (!stack1.isEmpty())
        {
            stack2.push(stack1.pop()) ;
        }
        
        int top = stack2.pop() ;
        
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop()) ;
        }
        
        return top ;
    }

    int peek() {
        
        if (stack1.isEmpty()) return -1 ;
        
        while (!stack1.isEmpty())
        {
            stack2.push(stack1.pop()) ;
        }
        
        int top = stack2.peek() ;
        
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop()) ;
        }
        
        return top ;
    }

    boolean isEmpty() {
        return stack1.isEmpty() ;
    }
}
