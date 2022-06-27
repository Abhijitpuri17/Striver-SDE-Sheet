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
		int numOfNodes = 0 ;
        LinkedListNode<Integer> curr = head ;
        
        while (curr != null){
            numOfNodes++ ;
            curr = curr.next ;
        }
        
        int fromStart = numOfNodes - K + 1 ;
        
        if (fromStart <= 0 || fromStart > numOfNodes) return head ;
        
        
        LinkedListNode<Integer> prev = head ;
        
        if (fromStart == 1) {
            return head.next ;
        }
        
        for (int i = 1; i < fromStart-1 ; i++){
            prev = prev.next ;
        }
        
        prev.next = prev.next.next ;
       
        return head ;
	}
}

