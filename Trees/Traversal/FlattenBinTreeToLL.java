/*
 Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.
 */
package interviewprep.Trees.Traversal;

/**
 *
 * @author jakadam
 */


/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* 
         1
        / \
       2   5
      / \   \
     3   4   6
     Execute below code for above example to understand
     
  */   

import java.util.*;
public class FlattenBinTreeToLL {
    public TreeNode flatten(TreeNode a) {
        if(a==null)
            return null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.add(a);
        
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            
            if(node.right != null)
                stack.push(node.right);
            if(node.left !=null)
                stack.push(node.left);
            if(!stack.isEmpty())    
                node.right = stack.peek();
            
            node.left=null;

        }
        
        return a;
    }
}


/*
Link-
https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
Note-
https://www.youtube.com/watch?v=vssbwPkarPQ
*/