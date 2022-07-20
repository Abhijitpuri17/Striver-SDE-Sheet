/*************************************************************
    Following is the Binary Search Tree node structure

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

*************************************************************/

import java.util.ArrayList;

public class Solution 
{
	public static int KthLargestNumber(TreeNode<Integer> root, int k) 
   {
		    int[] ans = {-1} ;
        revInorder(root, k, new int[]{0}, ans) ;
        return ans[0] ;
	 }
    
    static void revInorder(TreeNode<Integer> node, int k, int[] cnt, int[] ans)
    {
        if (node == null)
            return ;
        
        revInorder(node.right, k, cnt, ans) ;
        
        cnt[0]++ ;
        
        if (cnt[0] == k){
            ans[0] = node.data ;
        }
        
        revInorder(node.left, k, cnt, ans) ;
    }
    
}
