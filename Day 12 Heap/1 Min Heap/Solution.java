import java.util.* ;
public class Solution {

    static int[] minHeap(int n, int[][] queries) {
        
        int[] heap = new int[n+1] ;
        
        ArrayList<Integer> ansList = new ArrayList<>() ; 
        
        int i = 0 ;
        
        for (int[] q : queries)
        {
            if (q[0] == 0)
            {
                insert(heap, ++i, q[1]) ;
            }
            else
            {
                ansList.add(delete(heap, --i)) ;
            }
        }
        
        return ansList.stream().mapToInt(x->x).toArray() ;
    }
    
    static void insert(int[] heap, int i, int ele)
    {
        while (i > 1 && heap[i/2] >= ele)
        {
            heap[i] = heap[i/2] ;
            i /= 2 ;
        }
        heap[i] = ele ;
    }
    
    static int delete(int[] heap, int n)
    {
        int min = heap[1] ;
        
        heap[1] = heap[n] ;
        
        int i = 1;
        int j = 2*i;
        
        while (j < n)
        {
            if (heap[j+1] < heap[j]) j++ ;
            if (heap[j] <= heap[i])
            {
                swap(heap, i, j) ;
                i = j ;
            }
            else
                break ;
        }
        
        return min ;
    }
    
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i] ;
        arr[i] = arr[j] ;
        arr[j] = temp ;
    }
    
}
