/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

import java.util.*;

public class Solution {

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
        ArrayList<Integer> levelOrder = new ArrayList<>() ;
        
        ArrayDeque<BinaryTreeNode> q = new ArrayDeque<>() ;
        
        if (root != null)
        q.offerLast(root) ;
        
        while (!q.isEmpty())
        {
            BinaryTreeNode curr = q.pollFirst() ;
            levelOrder.add(curr.val) ;
                
            if (curr.left != null)
                q.add(curr.left) ;
                
            if (curr.right != null)
                q.add(curr.right) ;
        }
        
        return levelOrder ;
  }

}
