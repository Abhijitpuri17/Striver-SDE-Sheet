import java.util.* ;
import java.io.*; 
/****************************************************************

       Following is the class structure of the Node class:

       class Node {
    int data;
    Node next;
    Node child;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }
}

*****************************************************************/
public class Solution {
    public static Node getmid(Node head){
       if(head.child==null) return head;
        Node slow=head;
        Node fast=head.child;
        while(fast.child!=null)
        {
            slow=slow.child;
            fast=fast.child;
            if(fast.child!=null)
                fast=fast.child;
        }
        return slow;
    }
    
    public static Node merge(Node first,Node second){
        if(first==null) return second;
        if(second==null) return first;
        Node ans=new Node(-1);
        Node temp=ans;
        while(first!=null&& second!=null){
            if(first.data<=second.data){
                temp.child=first;
                first=first.child;
                temp=temp.child;
            }
            else{ 
                temp.child=second;
                second=second.child;
                temp=temp.child;
                 }
        }
        while(first!=null){
            temp.child=first;
                first=first.child;
                temp=temp.child;
        }
        while(second !=null){
            temp.child=second;
                second=second.child;
                temp=temp.child;
        }
        temp=ans.child;
        ans.child=null;
        return temp;
    }
    
    public static Node mergeSort(Node start){
         if (start == null || start.child == null) {
            return start;
        }
        Node mid=getmid(start);
        Node first=start;
        Node second=mid.child;
        mid.child=null;
        
        first=mergeSort(first);
        second=mergeSort(second);
        return merge(first,second);
    }
    
    public static Node flattenLinkedList(Node start) {
        Node head2=start;
        Node tail=start;
        Node prev1=null;     
        while(head2!=null)
        {   
            prev1=head2;
            head2=head2.next;
            prev1.next=null;  
            
        while(tail.child!=null){ 
            
            tail=tail.child;
         }
        tail.child=head2;
    }
      
        return mergeSort(start);
        
    }
}
