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
		LinkedListNode<Integer> nodeA = firstHead, nodeB = secondHead ;
        
        while (nodeA != nodeB)
        {
            nodeA = nodeA.next == null ? secondHead : nodeA.next ;
            nodeB = nodeB.next == null ? firstHead : nodeB.next ;
        }
        
        return nodeA.data ;
	}
}
