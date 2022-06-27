import java.util.* ;
public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        int n = start.size();
        
        Activity[] activities = new Activity[n] ;
        
        for (int i = 0 ; i < n;  i++)
        {
            activities[i] = new Activity(start.get(i), end.get(i)) ;
        }
        
        Arrays.sort(activities, (a1, a2)->{
            return a1.end - a2.end ;
        }) ;
        
        int ans = 0 ;
        
        int currEnd = 0 ;
        
        for (Activity a : activities)
        {
            if (a.start >= currEnd){
                ans++ ;
                currEnd = a.end ;
            }
        }
        
        return ans ;
    }
    
    static class Activity{
        int start, end ;
        Activity(int start, int end)
        {
            this.start = start ;
            this.end = end ;
        }
    }
    
}
