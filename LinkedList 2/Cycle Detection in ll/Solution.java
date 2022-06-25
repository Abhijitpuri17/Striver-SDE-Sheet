import java.util.* ;
import java.io.*; 
/*  

    Following is the representation of the Singly Linked List node

    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

*/

public class Solution {
    
    public static boolean detectCycle(Node<Integer> head) {
        Node<Integer> slow = head, fast = head ;

        do{
            slow = slow.next ;
            if (fast == null || fast.next == null) return false ;
            fast = fast.next.next ;
        } while (fast != slow) ;
        
        return true ;
    }
}
