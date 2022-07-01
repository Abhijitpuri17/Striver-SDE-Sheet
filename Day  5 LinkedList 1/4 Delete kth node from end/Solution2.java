import java.util.* ;
import java.io.*; 
/****************************************************************
	
	Following is the structure of the Singly Linked List.
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

****************************************************************/

public class Solution {
	public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {
		
        LinkedListNode<Integer> start = new LinkedListNode(0) ;
        LinkedListNode<Integer> q = start, p = start ;
        
        p.next = head ;
        
        for (int i = 0 ; i <= K; i++)  {
            p = p.next ;
        }

        while (p != null) {
            p = p.next ;
            q = q.next ;
        }
        
        if (q.next != null)
        q.next = q.next.next ;
        
        return start.next ;
        
	}
}
