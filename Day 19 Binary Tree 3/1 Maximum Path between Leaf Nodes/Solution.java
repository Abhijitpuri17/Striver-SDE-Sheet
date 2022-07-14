/************************************************************

    Following is the Tree node structure
	
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

************************************************************/

public class Solution 
{
    static long ans = -1 ;
    
	public static long findMaxSumPath(TreeNode root)
    {
		ans = -1;
        helper(root) ;
        return ans ;
	}
    
    public static long helper(TreeNode node)
    {
        if (node == null)
            return -1 ;
        
        long left = helper(node.left) ;
        long right = helper(node.right) ;
        
        if (left != -1 && right != -1)
            ans = Math.max(left + right + node.data , ans) ;
        
        long max = Math.max(left, right) ;
        
        if (max > 0)
            return max + node.data ;
       
        return node.data ;
    }
    
}
