import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        int min = Integer.MAX_VALUE ;
        
        int maxProfit = 0 ;
        
        for (int price : prices)
        {
            min = Math.min(price, min) ;
            maxProfit = Math.max(maxProfit, price - min) ;
        }
        
        return maxProfit ;
    }
}
