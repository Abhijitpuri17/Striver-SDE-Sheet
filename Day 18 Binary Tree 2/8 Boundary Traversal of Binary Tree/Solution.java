/************************************************************

    Following is the Binary Tree node structure:
    
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

import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<Integer> traverseBoundary(TreeNode root)
    {
		ArrayList<Integer> leftPart = new ArrayList<>(),
                           rightPart = new ArrayList<>(),
                           leafNodes = new ArrayList<>() ;
        
        getLeftPart(root.left, leftPart) ;
        getRightPart(root.right, rightPart) ;
        getLeafNodes(root.left, leafNodes) ;
        getLeafNodes(root.right, leafNodes) ;
        
        ArrayList<Integer> boundary = new ArrayList<>() ;
        boundry.add(root.data) ;
        
        for (int x: leftPart)
            boundary.add(x) ;
        
        if (root != null && root.left == null && leafNodes.size() > 0)
            boundary.add(leafNodes.get(0)) ;
        
        for (int i = 1; i < leafNodes.size(); i++)
        {
            boundary.add(leafNodes.get(i)) ;
        }
        
        for (int i  = 1; i < rightPart.size(); i++)
            boundary.add(rightPart.get(i)) ;
        
        return boundary ;
	}
    
    static void getLeftPart(TreeNode node, ArrayList<Integer> leftPart)
    {
        if (node == null)
            return ;
        leftPart.add(node.data) ;
        if(node.left != null)
            getLeftPart(node.left, leftPart) ;
        else
            getLeftPart(node.right, leftPart) ;
    }
    
    static void getRightPart(TreeNode node, ArrayList<Integer> rightPart)
    {
        if (node == null)
            return ;
        if (node.right != null)
            getRightPart(node.right, rightPart) ;
        else
            getRightPart(node.left, rightPart) ;
        rightPart.add(node.data) ;
    }
    
    static void getLeafNodes(TreeNode node, ArrayList<Integer> leafNodes)
    {
        if (node == null)
            return ;
        
        if (node.left == null && node.right == null)
            leafNodes.add(node.data) ;
        
        getLeafNodes(node.left, leafNodes) ;
        getLeafNodes(node.right, leafNodes) ;
    }
    
    
}
