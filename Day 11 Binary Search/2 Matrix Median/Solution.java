import java.util.*;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		int n = matrix.size();
        int m = matrix.get(0).size() ;
        
        ArrayList<Integer> temp = new ArrayList<>() ;
        
        for (ArrayList<Integer> list : matrix)
        {
            for (int num : list) temp.add(num) ;
        }
        
        Collections.sort(temp) ;
        
        return temp.get(n*m/2) ;
        
	}
}
