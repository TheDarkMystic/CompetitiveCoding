/*
 *
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest 
leaf node.

NOTE : The path has to end on a leaf node. 
Example :

         1
        /
       2
min depth = 2.
 */
package interviewprep.Trees.Traversal;

/**
 *
 * @author jakadam
 */
import java.util.*;


 
public class minDepthBinaryTree {
    public int minDepth(TreeNode root) {
        //check if root is null
        if(root==null)
            return 0;
        // check if root is leaf node
        if(root.left==null && root.right==null)
            return 1;
        
        int leftMinDepth= root.left!=null ? minDepth(root.left) : Integer.MAX_VALUE;
        int rightMinDepth= root.right!=null ? minDepth(root.right) : Integer.MAX_VALUE;
        
        return 1+Math.min(leftMinDepth,rightMinDepth);
    }
    
}
/*
Links-
https://www.interviewbit.com/problems/min-depth-of-binary-tree/
Notes-
https://www.youtube.com/watch?v=_pnqMz5nrRs

https://www.youtube.com/watch?v=hmWhJyz5kqc

https://leetcode.com/problems/minimum-depth-of-binary-tree/#/solutions
*/