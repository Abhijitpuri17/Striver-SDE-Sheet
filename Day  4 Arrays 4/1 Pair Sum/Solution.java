import java.util.* ;
import java.io.*; 
public class Solution{
    public static int[][] pairSum(int[] arr, int s) {
        ArrayList<int[]> ans = new ArrayList<>() ;
        
        HashMap<Integer, Integer> freq = new HashMap<>() ;
        
        for (int x: arr)
        {
            if (freq.containsKey(s - x)) {
                int f = freq.get(s-x) ;
                if (x < s - x){  
                    while (f-- > 0)
                  ans.add(new int[]{x, s-x}) ;
                }    
                else {
                    while (f-- > 0)
                    ans.add(new int[]{s-x, x}) ;
                 }
            }
            freq.put(x, freq.getOrDefault(x, 0)+1) ;
        }
        
        Collections.sort(ans, (a1, a2)->{
            if (a1[0] == a2[0]) return a1[1] - a2[1] ;
            return a1[0] - a2[0] ;
        }) ;
        
        int[][] ansArr = new int[ans.size()][2] ;
        
        int i = 0 ;
        for (int[] a : ans)
        {
            ansArr[i][0] = a[0] ;
            ansArr[i][1] = a[1] ;
            i++ ;
        }
        
        return ansArr ;
    }
}
