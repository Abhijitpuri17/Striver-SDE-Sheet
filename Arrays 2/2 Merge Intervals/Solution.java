import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        List<Interval> mergedIntervals = new ArrayList<>() ;
        
        Arrays.sort(intervals, (i1, i2)->{
            return i1.start - i2.start ;
        }) ;
      
        int start = intervals[0].start, finish = intervals[0].finish ;
        
        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i].start > finish) {
                mergedIntervals.add(new Interval(start, finish)) ;
                start = intervals[i].start ;
                finish = intervals[i].finish ;
            }
            
            finish = Math.max(finish, intervals[i].finish) ;  
        }
        
         mergedIntervals.add(new Interval(start, finish)) ;
        
        
        
        return mergedIntervals ;
  
    }
}
