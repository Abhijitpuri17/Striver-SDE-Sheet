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

import java.util.* ;
public class Solution 
{
    public static String serializeTree(TreeNode<Integer> root)
    {
        StringBuilder str = new StringBuilder("") ;
        
        Queue<TreeNode<Integer>>q = new LinkedList<>() ;
        
        if (root != null)
            q.add(root) ;
        
        while(!q.isEmpty())
        {
            TreeNode<Integer> curr = q.poll() ;
            
            if (curr == null)
            {
                str.append("x ") ;
                continue ;
            }
            
            str.append(curr.data +" ") ;
            
            q.add(curr.left) ;
            q.add(curr.right) ;
            
        }
        
        return str.toString() ;
    }
    
    public static TreeNode<Integer> deserializeTree(String str)
    {
       if (str.length() == 0)
            return null ;
        
        String[] vals = str.split(" ") ;
        
        TreeNode<Integer> root = new TreeNode(Integer.parseInt(vals[0])) ;
        
        Queue<TreeNode> q = new LinkedList<>() ;
        
        q.add(root) ;
        
        int n = vals.length ;
        
        for (int i = 1; i < n; i++)
        {
            TreeNode<Integer> parent = q.poll() ;
            
            if(vals[i].equals("x"))
            {
                parent.left = null ;
            }
            else
            {
                parent.left = new TreeNode(Integer.parseInt(vals[i])) ;
                q.add(parent.left) ;
            }
            i++ ;
            
            if (vals[i].equals("x"))
            {
                parent.right = null ;
            }
            else
            {
                parent.right = new TreeNode(Integer.parseInt(vals[i])) ;
                q.add(parent.right) ;
            }
        }
        
        return root ;
    }
}
