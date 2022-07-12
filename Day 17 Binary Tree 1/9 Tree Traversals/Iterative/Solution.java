/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/
import java.util.* ;
public class Solution 
{
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root)
    {
        List<List<Integer>> ans = new ArrayList<>() ;
        for (int i = 0; i < 3; i++) ans.add(new ArrayList<>()) ;
        
        Stack<Pair> stack = new Stack<>() ;
        
        if (root != null)
        {
            stack.push(new Pair(root, 0)) ;
        }
        
        while (!stack.isEmpty())
        {
            Pair p = stack.pop() ;
            
            ans.get(p.flag).add(p.node.data) ;
            
            p.flag++ ;
            
            if (p.flag < 3) {
                stack.push(p) ;
            }
            
            if (p.flag == 1 && (p.node.left != null)){
                stack.push(new Pair(p.node.left, 0)) ;
            }
            
            if (p.flag == 2 && p.node.right != null){
                stack.push(new Pair(p.node.right, 0)) ;
            }
        }
        
        List<Integer> temp = ans.get(0) ;
        ans.set(0, ans.get(1)) ;
        ans.set(1, temp) ;
        
        return ans ;
    }
}

class Pair{
    BinaryTreeNode<Integer> node;
    int flag ;
    
    Pair(BinaryTreeNode<Integer> node, int flag)
    {
        this.node = node ;
        this.flag = flag ;
    }
}

