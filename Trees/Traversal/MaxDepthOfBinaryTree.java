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
public class MaxDepthOfBinaryTree {
     public int maxDepth(TreeNode A) {
        int ans=calcDepth(A);
        return ans;
        
    }
    
     
    public int calcDepth(TreeNode A){
        // question has a definition refering to depth in terms of nodes hence return 0 for leaf
        // if height is refered to in terms of edges, return -1 for leaf;
        // watch video explaination from mycodeschool
        if(A==null)
            return 0;
        return 1+ Math.max(calcDepth(A.left),calcDepth(A.right));
    }
}

/*
Links-https://www.interviewbit.com/problems/max-depth-of-binary-tree/
Notes-
https://www.youtube.com/watch?v=_pnqMz5nrRs

https://www.youtube.com/watch?v=hmWhJyz5kqc

Both the videos are VIMP
*/