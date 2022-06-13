import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        int n = arr.size() ;
   
        int ans = arr.get(0) ;
        
        if (n == 1) return new ArrayList<>(Arrays.asList(ans)) ;
        
        int ans2 = arr.get(1) ;
        
        int cnt1 = 1, cnt2 = 1 ;
        
        for (int i = 2; i < n ; i++)
        {
            if (arr.get(i) == ans) {
                cnt1++ ;
            }
            else if (arr.get(i) == ans2){
                cnt2++ ;
            } else if (cnt1 == 0) {
                ans = arr.get(i) ;
                cnt1 = 1 ;
            } else if (cnt2 == 0){
                ans2 = arr.get(i) ;
                cnt2 = 1 ;
            } else {
                cnt1-- ;
                cnt2-- ;
            }     
        }
        
        cnt1 = cnt2 = 0 ;
        for (int i = 0 ; i < n ; i++)
        {
            if (arr.get(i) == ans) cnt1++ ;
            else if (arr.get(i) == ans2) cnt2++ ;
        }
        
        ArrayList<Integer> ansList = new ArrayList<>() ;
        if (cnt1 > n/3) ansList.add(ans) ;
        if (cnt2 > n/3) ansList.add(ans2) ;
        
        return ansList ;
    }
}
