/*************************************************************
    Following is the Binary Tree node structure

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

public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		BinaryTreeNode<Integer> curr = root ;
        int preVal = -1, succVal = -1 ;
        
        while (curr.data != key)
        {
            if (curr.data < key)
            {
                preVal = curr.data ;
                curr = curr.right ;
            }
            else
            {
                succVal = curr.data ;
                curr = curr.left ;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<Integer>() ;
        
        BinaryTreeNode<Integer> pre = curr.left ;
        
        while (pre != null)
        {
            preVal = pre.data ;
            pre = pre.right ;
        }
       
        BinaryTreeNode<Integer> succ = curr.right ;
       
        while (succ != null)
        {
            succVal = succ.data ;
            succ = succ.left ;
        }
        
        ans.add(preVal) ;
        ans.add(succVal) ;
    
        return ans ;
	}
}
