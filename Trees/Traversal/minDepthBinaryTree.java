/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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