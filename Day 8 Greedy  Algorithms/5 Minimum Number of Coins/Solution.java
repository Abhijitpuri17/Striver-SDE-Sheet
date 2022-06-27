public class Solution
{
public static int findMinimumCoins(int amount)
    {
       int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 1000} ;
    
       int i = denominations.length - 1 ;
    
       int coins = 0 ;
    
       while (i >= 0)
       {
           coins += amount / denominations[i] ;
           amount %= denominations[i] ;
           i-- ;
       }
    
      return coins ;
    }
}
