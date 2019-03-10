/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 
          1
         / \
        2   3

Return : True or 1 

Input 2 : 
         3
        /
       2
      /
     1

Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1. 
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
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
 
 /*
 
 A tree is called height balanced, when the diff between the heights of its both subtrees is <=1.
 Also, this property should hold for all its nodes.
 
 HeightBalanced Tree property
 Math.abs(leftSubTreeHeight - rightSubTreeHeight)<=1
 
 */
public class BalancedBinaryTree {
    public int isBalanced(TreeNode A) {
        //null tree is balanced
        // we are checking the root here hence return 1
        if(A==null)
            return 1;
        
        int ans=checkBalance(A);
        
        if(ans==-1)
            return 0;
        else 
            return 1;
        
        
    }
    
    public int checkBalance(TreeNode root){
        // here we are cheking for height(not height balance prop) of leaf nodes hence return 0 and not 1
        if(root==null)
            return 0;
        
        // call left subtree    
        int leftHeight=checkBalance(root.left);
            //this condition avoids traversing right subtree, as we already found unbalaned
            // subtree if leftHeight==-1
            if(leftHeight==-1)
                return -1;
                
        // call right subtree
        int rightHeight=checkBalance(root.right);
            if(rightHeight==-1)
                return -1;
        
        
        /*
        There is a reason we have been passing around -1 for unbalanced subtrees.
        For balanced trees we are returning (max_height+1)for that subtree,
        now for any left tree whose corresp. right tree is unbalanced and vice versa,
        if we return -1 for unbalanced subtree, it will make Math.abs(leftHeight-rightHeight)
        cross 1 and the whole tree will become height unbalanced.
        */
        if(Math.abs(leftHeight-rightHeight)>1)
            return -1;
        
        else // return the height of node
            return 1+Math.max(leftHeight,rightHeight);
        
        
    }
}

/*
Links-https://www.interviewbit.com/problems/balanced-binary-tree/
Notes-

https://www.youtube.com/watch?v=TWDigbwxuB4
https://www.youtube.com/watch?v=LU4fGD-fgJQ

*/