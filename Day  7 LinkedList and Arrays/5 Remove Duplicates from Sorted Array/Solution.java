import java.util.* ;
public class Solution 
{
	public static int removeDuplicates(ArrayList<Integer> arr,int n) 
	{
        
	    int i = 0 , j = 1 ;

	    if (arr.size() == 0) return 0 ;

	    for (; j < arr.size() ; j++)
	    {
	         if (arr.get(j) != arr.get(j-1)) arr.set(++i, arr.get(j)) ; 
	    }

	    return i+1 ;
        
	}
}
