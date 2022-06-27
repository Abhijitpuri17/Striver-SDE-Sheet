import java.util.* ;
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        Arrays.sort(jobs, (j1, j2)->{
            if (j1[1] == j2[1]) {
                return j1[0] - j2[0] ;
            }
            return j2[1] - j1[1] ;
        }) ;
        
        int max = 0 ;
        
        for (int[] job : jobs)
        {
            max = Math.max(max, job[0]) ;
        }
        
        boolean[] isSlotOccupied = new boolean[max+1] ;
        int profit = 0 ;
        
        for (int[] job: jobs)
        {
            int deadline = job[0] - 1;
            while (deadline >= 0 && isSlotOccupied[deadline]) deadline-- ;
            
            if (deadline >= 0) {
                profit += job[1] ;
                isSlotOccupied[deadline] = true ;
            }  
        }
        
        return profit ;
    }
}
