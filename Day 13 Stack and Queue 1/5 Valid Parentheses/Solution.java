import java.util.Stack ;
public class Solution {
    public static boolean isValidParenthesis(String expression) {
        Stack<Character> stack = new Stack() ;
        
        for (int i = 0;  i < expression.length(); i++)
        {
            char ch = expression.charAt(i) ;
            
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch) ;
                continue ;
            }
            
            if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false ;
            }
            
            if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return false ;
            }
            
            if (ch == '}') {
                if (stack.isEmpty() || stack.peek() != '{') return false ;
            }
            
            stack.pop() ;
        }
        
        return stack.isEmpty() ;
        
    }
}
