/************************************************************

    Following is the TreeNode class structure

    class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	   }
	}


************************************************************/
import java.util.* ;
public class Solution {
   
    public static int getMaxWidth(TreeNode root) 
    { 
        Queue<TreeNode> q = new LinkedList<>() ;
        
        if (root != null)
        q.add(root) ;
        
        int width = 0 ;
        
        while (!q.isEmpty())
        {       
            int size = q.size() ;
            
            width = Math.max(width, size) ;
              
            for (int i = 0 ; i < size ; i++)
            {
                TreeNode curr = q.poll() ;
                      
                if (curr.left != null) {
                    q.add(curr.left) ;
                }
                
                if (curr.right != null)
                {
                    q.add(curr.right) ;
                }

            }
            
        }
        
        return width ;
 
    }

}
