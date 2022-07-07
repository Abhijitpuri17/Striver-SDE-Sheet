import java.util.* ;
public class Solution {

    static class MinStack {

        Stack<Pair> stack ;
        
        MinStack() {
            stack = new Stack<>() ;
        }

        void push(int num) {
            int min = Integer.MAX_VALUE ;
            if (!stack.isEmpty()){
                min = stack.peek().min ;
            }
            min = Math.min(min, num) ;
            stack.push(new Pair(num, min)) ;
        }

        int pop() {
            if (stack.isEmpty()) return -1 ;
            return stack.pop().val ;
        }

        int top() {
           if (stack.isEmpty()) return -1 ;
            return stack.peek().val ;
        }

        int getMin() {
           if (stack.isEmpty()) return -1 ;
           return stack.peek().min ; 
        }
    }
}

class Pair{
    int val, min ;
    Pair(int val, int min)
    {
        this.val = val ;
        this.min = min ;
    }
}




