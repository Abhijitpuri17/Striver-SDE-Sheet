import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
		{
		    public int data;
		    public Node next;

		    Node(int data)
		    {
		        this.data = data;
		        this.next = null;
		    }
		}

*****************************************************************/

public class Solution 
{
    public static Node firstNode(Node head) 
    {
        if (head == null) return null ;
        
        Node slow = head, fast = head ;
        
        do{
            slow = slow.next ;
            if (fast == null || fast.next == null) return null ;
            fast = fast.next.next ;
        } while (slow != fast) ;
        
        fast = head ;
        while (slow != fast) {
            slow = slow.next ;
            fast = fast.next ;
        }
        
        return slow ;
    }
}
