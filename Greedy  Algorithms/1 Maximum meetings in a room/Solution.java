import java.util.* ;
public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {        
        int n = start.length ;
        
        Meeting[] meetings = new Meeting[n] ;
        
        for (int i = 0 ; i < n ; i++)
        {
            meetings[i] = new Meeting(start[i], end[i], i) ;
        }
        
        Arrays.sort(meetings, (m1, m2)->{
            if (m1.end == m2.end) {
                return m1.meetingNumber - m2.meetingNumber ;
            }
            return m1.end - m2.end ;
        }) ;
        
        int currEnd = 0 ;
        
        List<Integer> ans = new ArrayList<>() ;
        
        for (int i = 0 ; i < n ; i++)
        {
            
            if (meetings[i].start > currEnd || 
                (meetings[i].start == 0 && currEnd == 0)
               ) {
                ans.add(meetings[i].meetingNumber + 1) ;
                currEnd = Math.max(currEnd, meetings[i].end) ;
            }
        }
        
        return ans ;
        
    }
    
    static class Meeting{
        int start, end, meetingNumber ;
        Meeting(int start, int end, int meetingNumber)
        {
            this.start = start ;
            this.end = end ;
            this.meetingNumber = meetingNumber ;
        }
    }
}
