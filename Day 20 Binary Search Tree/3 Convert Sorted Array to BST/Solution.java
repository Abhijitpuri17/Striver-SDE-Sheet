/****************************************************************

    Following is the class structure of the TreeNode class:

    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


*****************************************************************/

import java.util.ArrayList;

public class Solution
{
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) 
    {
       return construct(arr, 0, n-1) ;
    }
    
    public static TreeNode<Integer> construct(ArrayList<Integer> arr, int start, int end)
    {
        if (start > end)
            return null ;
        
        int mid = start + ((end-start)>>1) ;
        
        TreeNode<Integer> left = construct(arr, start,  mid-1) ;
        TreeNode<Integer> right = construct(arr, mid+1, end) ;
        
        TreeNode<Integer> node = new TreeNode<Integer>(arr.get(mid)) ;
        
        node.left = left ;
        node.right = right ;
       
        return node ;
        
    }
    
}
