import java.util.* ;
import java.io.*; 
/************************************
	 
	 //Following is the class structure of the LinkedListNode class:
	 
	  class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;
		
		public LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

*****************************************/
public class Solution {

	public static int findIntersection(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {
		LinkedListNode<Integer> node1 = firstHead, node2 = secondHead ;
        int count1 = 0, count2 = 0 ;
        while (node1 != null) {
            count1++ ;
            node1 = node1.next ;
        }
        
        while (node2 != null){
            count2++ ;
            node2 = node2.next ;
        }
        
        node1 = firstHead ;
        node2 = secondHead ;
    
        if (count1 > count2) {
            for (int i = 0 ; i < count1 - count2; i++) {
                node1 = node1.next ;
            }
        } else{
            for (int i = 0 ; i < count2 - count1; i++)
            {
                node2 = node2.next ;
            }
        }
        
        while (node1 != node2) {
            node1 = node1.next ;
            node2 = node2.next ;
        }
        
        if (node1 == null) return -1 ;
        return node1.data ;
	}
}
