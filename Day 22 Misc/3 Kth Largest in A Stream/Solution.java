import java.util.* ;
public class Kthlargest {
    
    PriorityQueue<Integer> pq ;
    
    Kthlargest(int k, int[] arr) {
        pq = new PriorityQueue<>() ;
        for (int num: arr)
        {
            pq.add(num) ;
        }
    }

    void add(int num) {
        if (pq.peek() < num){
            pq.poll() ;
            pq.add(num) ;
        }
    }

    int getKthLargest() {
       return pq.peek() ;
    }
}
