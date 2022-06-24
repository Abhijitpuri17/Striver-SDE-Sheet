import java.util.* ;

import java.io.*; 

/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {

        int data;

        LinkedListNode next;

        

        public LinkedListNode(int data) {

            this.data = data;

        }

    }

*****************************************************************/

class Solution 

{

    public static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) 

    {

        int carry = 0 ;

        LinkedListNode l3 = new LinkedListNode(0) ;

        LinkedListNode head = l3 ;

        while (l1 != null && l2 != null)

        {

            int curr = l1.data + l2.data + carry ;

            carry = curr / 10 ;

            l3.next = new LinkedListNode(curr % 10) ;

            l3 = l3.next ;

            l1 = l1.next ;

            l2 = l2.next ;    

        }

        

        if (l2 != null){

            while (l2 != null)

            {

                int curr = l2.data + carry ;

                carry = curr / 10 ;

            l3.next = new LinkedListNode(curr % 10) ;

            l3 = l3.next ;

            l2 = l2.next ; 

            }

        }

        

        else if (l1 != null){

            while (l1 != null)

            {

                int curr = l1.data + carry ;

              carry = curr / 10 ;

            l3.next = new LinkedListNode(curr % 10) ;

            l3 = l3.next ;

            l1 = l1.next ; 

            }

        }

        

        if (carry != 0) l3.next = new LinkedListNode(carry) ;

        

     return head.next ;

    }  

}

