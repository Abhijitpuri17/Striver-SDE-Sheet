/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.*;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        ArrayList<Integer> leftView = new ArrayList<>() ;
        
        if (root == null) return leftView ;
        
        Queue<TreeNode<Integer>> q = new LinkedList<>() ;
        q.add(root) ;
        
        while (!q.isEmpty())
        {
            int size = q.size() ;
            
            leftView.add(q.peek().data) ;
            
            for(int i = 0 ; i < size; i++)
            {
                TreeNode<Integer> curr = q.poll() ;
                if (curr.left != null)
                    q.add(curr.left) ;
                if (curr.right != null)
                    q.add(curr.right) ;
            }
            
        }
        return leftView ;
    }
}
