import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        StockSpanner stockSpanner = new StockSpanner() ;
        ArrayList<Integer> spans = new ArrayList<>() ;
        for (int p: price)
        {
            spans.add(stockSpanner.next(p)) ;
        }
        return spans;
    }
}

class StockSpanner {

    Stack<Pair> stack ;
    
    public StockSpanner() {
        stack = new Stack<>() ;
    }
    
    public int next(int price) 
    {
        int span = 1 ;
        
        while (!stack.isEmpty() && price >= stack.peek().val)
            span += stack.pop().span ;
        
        stack.push(new Pair(price, span)) ;
        
        return span ;
    }
}

class Pair{
    int val ;
    int span ;
    
    Pair(int val, int span)
    {
        this.val = val ;
        this.span = span ;
    }
}
