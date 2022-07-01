public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
       
        int[] numberOfTrainsAtT = new int[2401] ;
        
        for (int i = 0 ; i < n ; i++)
        {
            numberOfTrainsAtT[at[i]]++ ;
            numberOfTrainsAtT[dt[i]+1]-- ;
        }
        
        int ans = 0 ;
        int currTrains = 0 ;
        for (int i = 0 ; i < 2401; i++)
        {
            currTrains += numberOfTrainsAtT[i] ;
            ans = Math.max(ans, currTrains) ;
        }
        
        return ans ;
    }
}
