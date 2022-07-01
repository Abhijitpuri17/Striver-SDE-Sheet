/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/

import java.util.* ;
public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
         
         Arrays.sort(items, (i1, i2)->{
             if ((i1.value*1.0/i1.weight) > (i2.value*1.0/i2.weight)) return -1 ;
             return 1 ;
         }) ;
         
        double ans = 0 ;
        
        for (int i = 0; i < n && w > 0 ; i++)
        {
           if (items[i].weight <= w){
               ans += items[i].value ;
               w -= items[i].weight ;
           } else{
               ans += items[i].value*1.0/items[i].weight * w ;
               w = 0 ;
           }
        }
        
        return ans ;
        
    }
}
