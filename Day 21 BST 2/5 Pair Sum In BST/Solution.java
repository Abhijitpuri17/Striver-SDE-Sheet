/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }

*************************************************************/
import java.util.* ;
public class Solution {
	public static boolean pairSumBst(BinaryTreeNode root, int k) {
		ArrayList<Integer> list = new ArrayList<>() ;
        inorder(root, list) ;
        
        int start = 0, end = list.size() - 1 ;
        
        while (start < end)
        {
            int val = list.get(start) + list.get(end);
            if (val == k)
                return true ;
            if (val < k)
                start++ ;
            else 
                end-- ;
        }
        
        return false ;
	}
    
    static void inorder(BinaryTreeNode node, ArrayList<Integer> list)
    {
        if (node == null )
            return ;
        
        inorder(node.left, list) ;
        list.add(node.data) ;
        inorder(node.right, list) ;
    }
    
}

