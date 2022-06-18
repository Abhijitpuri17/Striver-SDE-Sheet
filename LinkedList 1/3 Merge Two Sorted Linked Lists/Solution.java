import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		
        if (first == null) return second ;
        if (second == null) return first ;
        
        if (first.data > second.data){
            LinkedListNode<Integer> temp  = first ;
            first = second ;
            second = temp ;
        }
        
        LinkedListNode<Integer> p = first, q = second ;
        LinkedListNode<Integer> curr = null ;
        
        while (p != null && q != null)
        {
            while (p != null && p.data <= q.data) {
                curr = p ;
                p = p.next ;
            }
            
            curr.next = q ;
            
            LinkedListNode<Integer> temp  = p ;
            p = q ;
            q = temp ;   
        }
        
        return first ;
	}
}
