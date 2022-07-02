
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    
	public static void findMedian(int arr[])  {
        MedianFinder mf = new MedianFinder() ;
        
        for (int num : arr)
        {
            mf.addNum(num) ;
            System.out.print(mf.findMedian() + " ") ;
        }
        
        System.out.println() ;
        
    }
}


class MedianFinder {
    
    PriorityQueue<Integer> small ;
    PriorityQueue<Integer> large ;
    
    boolean isSizeEven = true ;

    public MedianFinder() {
        small = new PriorityQueue<>((p1, p2)->{
                return p2 - p1 ;
             }) ;
        
        large = new PriorityQueue<>() ;
    
    }
    
    public void addNum(int num) {
        
        if (isSizeEven)
        {
            large.add(num) ;
            small.add(large.poll()) ;
        }
        else
        {
            small.add(num) ;
            large.add(small.poll()) ;
        }
        
        isSizeEven = !isSizeEven ;
    }
    
    public int findMedian() {
        
        if (isSizeEven) {
            return (small.peek() + large.peek())/2 ;
        }
        
        return small.peek() ;
    }
}
