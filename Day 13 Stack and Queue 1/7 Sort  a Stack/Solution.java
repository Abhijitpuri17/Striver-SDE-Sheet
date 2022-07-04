import java.util.* ;
public class Solution {
    
    public static void insert(Stack<Integer> stack, int num)
    {
        if(stack.isEmpty() || stack.peek() <= num) {
            stack.push(num) ;
            return ;
        }
        
        int top = stack.pop() ;
        insert(stack, num) ;
        stack.push(top) ;
    }
    
	public static void sortStack(Stack<Integer> stack) {
		
        if (stack.isEmpty()){
            return;
        }
        
        int num = stack.pop() ;
        
        sortStack(stack) ;
        
        insert(stack,num) ;
        
	}

}
