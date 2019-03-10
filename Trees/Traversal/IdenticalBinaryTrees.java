/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 

   1       1
  / \     / \
 2   3   2   3

Output : 
  1 or True
*/
package interviewprep.Trees.Traversal;

/**
 *
 * @author jakadam
 */
public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode A, TreeNode B) {
        // null trees are identical
        if(A==null && B==null)
            return 1;
        
        if(A!=null && B!=null){// if both nodes are not null-> avoids nullpointerException
            
            //check node values and make recursive calls to subtrees
            if(A.val==B.val && isSameTree(A.left, B.left)==1
                            && isSameTree(A.right, B.right)==1)
                            return 1;
        }
        
        
        return 0;
    }
}
/*
Links-
https://www.interviewbit.com/problems/identical-binary-trees/
Notes-
https://www.youtube.com/watch?v=kL5Gs1YTwMM
*/