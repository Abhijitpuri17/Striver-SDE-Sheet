import java.util.* ;
import java.io.*; 
/***********************************************
    Following is the class structure of the Node class:

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
      
        int count = 0 ;
        Node node = head ;
        Node last = head ;
      
        while (node != null)
        {
            count++ ;
            last = node ;
            node = node.next ;
        }
        
        last.next = head ;
        
        k %= count ;
        
        node = head ;
        int x = count - k - 1 ;
        
        while (x > 0)
        {
            node = node.next ;
            x-- ;
        }
        
        Node ans = node.next ;
        node.next = null ;
        
        return ans ;
    }
}
