import java.util.* ;
public class Solution {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		    int ans = 1 ;
        
        for (int i = 0 ; i < n-1; i++)
        {
            if (arr.get(i) != arr.get(i+1)) {
                ans++ ;
            }
        }
        
        return ans ;
	}
}
