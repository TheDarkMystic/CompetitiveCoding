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
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Example :

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/
public class PathSum {
    public int hasPathSum(TreeNode root, int sum) {
        
        if(root==null)
            return 0;//false
            
        //leaf node with path sum found    
        if(root.left==null && root.right==null && sum-root.val==0)
            return 1;//true
        
        //make recursive call to children
        if (hasPathSum(root.left, sum-root.val)==1 ||
            hasPathSum(root.right, sum-root.val)==1)
            return 1;
        else return 0;
        
    }
}
/*
Links-https://www.interviewbit.com/problems/path-sum/
Notes-

https://leetcode.com/problems/path-sum/#/solutions
*/